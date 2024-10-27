import { Component } from '@angular/core';
import { ApiAnalizerService } from '../../service/api/api-analizer.service';
import { ReportCaptcha } from '../../model/ReportCaptcha';

@Component({
  selector: 'app-captcha-usage-report',
  standalone: true,
  imports: [],
  templateUrl: './captcha-usage-report.component.html',
  styleUrl: './captcha-usage-report.component.css',
})
export class CaptchaUsageReportComponent {
  list: ReportCaptcha[] = [];

  constructor(private apiService: ApiAnalizerService) {
    this.apiService.getListReportCaptcha().subscribe((data) => {
      data.forEach((element) => {
        const newReport = ReportCaptcha.fromJSON(element);
        this.list.push(newReport);
      });
    }),
      (error) =>
        console.error(
          'Error al obtener el listado de reporte captchas:',
          error
        );
  }
}
