import { ChangeDetectionStrategy, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { GenerarSolicitudCaptcha } from '../../model/GenerarSolicitudCaptcha';
import { HttpClientModule } from '@angular/common/http';
import { ApiAnalizerService } from '../../service/api/api-analizer.service';
import { Router } from '@angular/router';
import { ListErrorsService } from '../../service/list-errors-behavior/list-errors.service';

@Component({
  selector: 'app-captcha-generator',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './captcha-generator.component.html',
  styleUrl: './captcha-generator.component.css',
})
export default class CaptchaGeneratorComponent {
  private readonly CAPTCHA_URL: string = 'http://localhost:8080/';
  private readonly WAS_ACCEPTED: string = 'Fue aceptado : ';
  areText: string = '';
  idCaptcha: string = '';
  url: string = '';
  showApiMessage: boolean = false;

  constructor(private apiService: ApiAnalizerService,
    private router: Router,
    private serviceListErrors:ListErrorsService
  ) {
  }

  showAnswer(solicitud: GenerarSolicitudCaptcha) {
    if (solicitud.getId().length > 0) {
      this.showApiMessage = true;
      this.url = this.CAPTCHA_URL + solicitud.getId();
      this.idCaptcha = this.WAS_ACCEPTED + solicitud.getId();
    } else {
      this.serviceListErrors.upDataErrores(solicitud.getListError())
      this.router.navigate(['/list-error']);
    }
  }

  closeMenssage() {
    this.showApiMessage = false;
  }

  analizar() {
    const solicitud: GenerarSolicitudCaptcha = new GenerarSolicitudCaptcha(
      this.areText,
      '',
      []
    );
    this.apiService.postSolititudCaptchaAnalyzer(solicitud).subscribe(
      (data) => {
        const solicitudGenerada = GenerarSolicitudCaptcha.fromJSON(data);
        this.showAnswer(solicitudGenerada);
      },
      (error) => console.error('Error al obtener solicitud', error)
    );
  }
}
