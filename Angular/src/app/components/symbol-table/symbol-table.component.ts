import { Component } from '@angular/core';
import { CaptchaLink } from '../../model/CaptchaLink';
import { JisonServiceService } from '../../service/jison/jison-service.service';
import { ApiAnalizerService } from '../../service/api/api-analizer.service';

@Component({
  selector: 'app-symbol-table',
  standalone: true,
  imports: [],
  templateUrl: './symbol-table.component.html',
  styleUrl: './symbol-table.component.css'
})
export class SymbolTableComponent {
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
