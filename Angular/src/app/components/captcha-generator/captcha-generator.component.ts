import { ChangeDetectionStrategy, Component } from '@angular/core';
import { ApiAnalizerService } from '../../service/api-analizer.service';
import { FormsModule } from '@angular/forms';
import { GenerarSolicitudCaptcha } from '../../model/GenerarSolicitudCaptcha';
import { interval, Subscription } from 'rxjs';

@Component({
  selector: 'app-captcha-generator',
  standalone: true,
  changeDetection: ChangeDetectionStrategy.OnPush,
  imports: [FormsModule],
  templateUrl: './captcha-generator.component.html',
  styleUrl: './captcha-generator.component.css',
})
export default class CaptchaGeneratorComponent {
  private readonly CAPTCHA_URL: string = 'http://localhost:8080/';
  private readonly WAS_ACCEPTED: string = 'Fue aceptado : ';
  private timerSubscription?: Subscription;

  private isRunning: boolean = false;
  areText: string = '';
  idCaptcha:string = '';
  url:string = '';
  showApiMessage:boolean = false;

  constructor(private apiService: ApiAnalizerService) {}

  startTimer() {
    this.isRunning = true;
    this.timerSubscription = interval(15000).subscribe(() => {
      this.showApiMessage = !this.showApiMessage;
    });
  }

  stopTimer() {
    this.isRunning = false;
    if (this.timerSubscription) {
      this.timerSubscription.unsubscribe();
    }
  }

  showAnswer(solicitud: GenerarSolicitudCaptcha) {
    if (solicitud != null) {
      console.log(solicitud);
      if (solicitud.getListError.length > 0) {
        this.url = this.CAPTCHA_URL + solicitud.getId;
        this.idCaptcha = this.WAS_ACCEPTED + solicitud.getId;
      }else{
        this.startTimer();
      }
    }
  }

  analizar() {
    var solicitud: GenerarSolicitudCaptcha = new GenerarSolicitudCaptcha(
      this.areText,
      '',
      []
    );
    console.log(solicitud);
    this.apiService.getData(solicitud).subscribe((data) => {
      this.showAnswer(data);
    });
  }
}
