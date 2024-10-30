import { Component, ElementRef, Renderer2, ViewChild } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiAnalizerService } from '../../service/api/api-analizer.service';
import { DataValueDebbuge } from '../../model/SymbolTable/DataValueDebbuge';
import { ReportErrorInterpreter } from '../../model/Analyzer/ReportErrorInterpreter';
import { ListErrorsService } from '../../service/list-errors-behavior/list-errors.service';
import { ErrorListingComponent } from '../error-listing/error-listing.component';

@Component({
  selector: 'app-table-execution',
  standalone: true,
  imports: [ErrorListingComponent],
  templateUrl: './table-execution.component.html',
  styleUrl: './table-execution.component.css',
})
export class TableExecutionComponent {
  @ViewChild('codeArea', { static: false })
  codeArea!: ElementRef<HTMLDivElement>;
  id!: string;
  private listArray: DataValueDebbuge[] = [];
  textArea = '';
  index = 0;
  private listError: ReportErrorInterpreter[] = [];
  viewListErro:Boolean = false;

  viewListArray: DataValueDebbuge[] = [];

  constructor(
    private route: ActivatedRoute,
    private apiService: ApiAnalizerService,
    private renderer: Renderer2,
    private serviceListErrors:ListErrorsService
  ) {}

  nextList() {
    this.index++;
    this.colorDiv();
  }

  addListView(index: number, indexEnd: number) {
    if (index == 0 || index == indexEnd) {
      this.viewListArray = [];
    }
  }

  ngOnInit(): void {
    // Usando snapshot (captura instantánea de los parámetros)
    this.id = this.route.snapshot.paramMap.get('id')!;

    // Listado Symbol
    this.apiService.getSymbolTable(this.id).subscribe((data) =>
      data.forEach((element) => {
        const dataValueDebbuge = DataValueDebbuge.fromJSON(element);
        this.listArray.push(dataValueDebbuge);
      })
    ),
      (error) =>
        console.error('Error al obtener el listado de captchas:', error);
    // Texto de area
    this.apiService.getStringScripting(this.id).subscribe((data) => {
      if (!data) {
        console.warn('La respuesta es un string vacío.');
      } else {
        this.textArea = data.toString();
      }
    }),
      (error) =>
        console.error('Error al obtener el listado de captchas:', error);
    // Listado errores sintactico
    this.apiService.getListErrorSintactico(this.id).subscribe((data) =>
      data.forEach((element) => {
        const reportErrorInterpreter = ReportErrorInterpreter.fromJSON(element);
        this.listError.push(reportErrorInterpreter);
      })
    ),
      (error) =>
        console.error('Error al obtener el listado de captchas:', error);

    if (this.listError.length > 0) {
      this.serviceListErrors.upDataErrores(this.listError)
      this.viewListErro = true;
    }
  }

  ngAfterViewInit() {
    if (this.codeArea) {
      // Verifica que codeArea no sea undefined
      this.colorDiv();
    } else {
      console.error('codeArea no está disponible');
    }
  }
  colorDiv() {
    // Limpiar el contenido previo
    this.renderer.setProperty(this.codeArea.nativeElement, 'innerHTML', '');

    // Dividir el texto en líneas
    const lines = this.textArea.split('\n');
    this.addListView(this.index, lines.length);

    this.index = this.index >= lines.length ? 0 : this.index;

    lines.forEach((line, idx) => {
      line = !(/^\s*$/.test(line) && idx === this.index) ? line : '####';
      // Crear un nuevo div para cada línea
      const nuevoDiv = this.renderer.createElement('div');
      const text = this.renderer.createText(line);
      this.renderer.appendChild(nuevoDiv, text);

      // Colorear la línea si es la indicada por this.index
      if (idx === this.index) {
        this.listArray.forEach((element) => {
          if (
            line.includes(element.getId()) &&
            !this.viewListArray.includes(element)
          ) {
            element.setLine(idx);
            this.viewListArray.push(element);
          }
        });
        this.renderer.setStyle(nuevoDiv, 'color', 'red'); // Colocar texto en rojo solo en la línea indicada
      }

      // Insertar el nuevo div dentro del div existente
      this.renderer.appendChild(this.codeArea.nativeElement, nuevoDiv);
    });
  }
}
