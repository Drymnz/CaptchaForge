import {  ChangeDetectionStrategy, Component } from '@angular/core';
import {  FormsModule  } from '@angular/forms';
import { ApiAnalizerService } from '../service/api-analizer.service';
import { GenerarSolicitudCaptcha } from '../model/GenerarSolicitudCaptcha';

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
    var solicitud:GenerarSolicitudCaptcha = new GenerarSolicitudCaptcha(this.texto,[]);
    console.log(solicitud)
    this.apiService.getData(solicitud).subscribe(
      data=>{
        console.log((data));
      }
    );
  }
}
``