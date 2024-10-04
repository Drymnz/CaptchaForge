import {  ChangeDetectionStrategy, Component } from '@angular/core';
import {  FormsModule  } from '@angular/forms';
import { ApiAnalizerService } from '../service/api-analizer.service';

@Component({
  selector: 'app-analyzerhtml',
  standalone: true,
  changeDetection:ChangeDetectionStrategy.OnPush,
  imports: [FormsModule],
  templateUrl: './analyzerhtml.component.html',
  styleUrl: './analyzerhtml.component.css',
  
})

export class AnalyzerhtmlComponent {
  texto: string = '';

  constructor(private apiService:ApiAnalizerService){

  }

  analizar(){
    this.apiService.getData(this.texto).subscribe(
      (data: String[]) => {
        console.log(data); // Aquí obtienes los datos correctamente
      },
      error => {
        console.error('Error al obtener los datos', error); // Manejo de errores
      }
    );
  }
}
``