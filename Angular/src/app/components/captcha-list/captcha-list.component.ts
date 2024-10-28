import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { JisonServiceService } from '../../service/jison/jison-service.service';
import { ApiAnalizerService } from '../../service/api/api-analizer.service';
import { HttpClientModule } from '@angular/common/http';
import { CaptchaLink } from '../../model/CaptchaLink';

@Component({
  selector: 'app-captcha-list',
  standalone: true,
  imports: [FormsModule,HttpClientModule],
  templateUrl: './captcha-list.component.html',
  styleUrl: './captcha-list.component.css',
})
export class CaptchaListComponent {
  private areaTextUse = '';
  list:CaptchaLink[] = []

  constructor(private jisonServiceService:JisonServiceService,private apiService: ApiAnalizerService){
    this.apiService.getListCaptcha().subscribe(
      data => 
          this.areaTextUse = JSON.stringify(data)
    ),(error) => 
      console.error('Error al obtener el listado de captchas:', error);
    ;
    this.list = this.jisonServiceService.parse(this.areaTextUse)
  }

}
