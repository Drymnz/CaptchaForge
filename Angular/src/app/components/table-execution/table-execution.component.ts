import { Component, ElementRef, Renderer2, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiAnalizerService } from '../../service/api/api-analizer.service';
import { DataValueDebbuge } from '../../model/SymbolTable/DataValueDebbuge';

@Component({
  selector: 'app-table-execution',
  standalone: true,
  imports: [],
  templateUrl: './table-execution.component.html',
  styleUrl: './table-execution.component.css'
})
export class TableExecutionComponent {
  @ViewChild('codeArea', { static: false }) codeArea!: ElementRef<HTMLDivElement>;
  id!: string;
  private listArray: DataValueDebbuge[] = [];
  textArea = ''
  index = 0
  
  viewListArray: DataValueDebbuge[] = [];

  constructor(private route: ActivatedRoute,private apiService: ApiAnalizerService
    ,private renderer: Renderer2
  ) {}

  nextList(){
    this.colorDiv()
    this.index++
  }

  ngOnInit(): void {


    // Usando snapshot (captura instantánea de los parámetros)
    this.id = this.route.snapshot.paramMap.get('id')!;

    // Listado Symbol 
    this.apiService.getSymbolTable(this.id).subscribe(
      data => data.forEach((element) => {
        const dataValueDebbuge = DataValueDebbuge.fromJSON(element);
        this.listArray.push(dataValueDebbuge);
      })
    ),(error) => 
      console.error('Error al obtener el listado de captchas:', error);
    ;

    console.log(this.listArray)

    // Texto de area
    this.apiService.getStringScripting(this.id).subscribe(
      data => {
        if (!data) {
          console.warn('La respuesta es un string vacío.');
        } else {
          this.textArea = data.toString()
        }
      }
    ),(error) => 
      console.error('Error al obtener el listado de captchas:', error);
    ;
    console.log(this.textArea)
  }

  ngAfterViewInit() {
    if (this.codeArea) { // Verifica que codeArea no sea undefined
      this.colorDiv();
    } else {
      console.error('codeArea no está disponible');
    }
  }
  colorDiv(){
// Dividir el texto en líneas
const lines = this.textArea.split('\n');

lines.forEach((line, idx) => {
  // Crear un nuevo div para cada línea
  const nuevoDiv = this.renderer.createElement('div');
  const text = this.renderer.createText(line);
  this.renderer.appendChild(nuevoDiv, text);

  // Colorear la línea si es la indicada por this.index
  if (idx === this.index) {
    this.renderer.setStyle(nuevoDiv, 'color', 'red'); // Colocar texto en rojo solo en la línea indicada
  }

  // Insertar el nuevo div dentro del div existente
  this.renderer.appendChild(this.codeArea.nativeElement, nuevoDiv);
});
  }
}
