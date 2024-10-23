import { Component } from '@angular/core';
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
  id!: string;
  private listArray: DataValueDebbuge[] = [];
  private codeArea:HTMLElement | undefined;
  textArea = ''
  
  viewListArray: DataValueDebbuge[] = [];

  constructor(private route: ActivatedRoute,private apiService: ApiAnalizerService) {}

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
    //this.codeArea = document.createElement('codeArea');
  }
}
