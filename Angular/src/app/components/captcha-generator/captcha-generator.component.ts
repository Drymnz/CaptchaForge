import { ChangeDetectionStrategy, Component } from '@angular/core';
import { ApiAnalizerService } from '../../service/api-analizer.service';
import { GenerarSolicitudCaptcha } from '../../model/GenerarSolicitudCaptcha';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-captcha-generator',
  standalone: true,
  changeDetection:ChangeDetectionStrategy.OnPush,
  imports: [FormsModule],
  templateUrl: './captcha-generator.component.html',
  styleUrl: './captcha-generator.component.css'
})
export default class CaptchaGeneratorComponent {
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
