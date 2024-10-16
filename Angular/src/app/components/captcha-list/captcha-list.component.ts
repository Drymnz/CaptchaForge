import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { JisonServiceService } from '../../service/jison/jison-service.service';
declare const parse: (input: string) => any;

@Component({
  selector: 'app-captcha-list',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './captcha-list.component.html',
  styleUrl: './captcha-list.component.css',
})
export class CaptchaListComponent {
  areText = '';


  constructor(private jisonServiceService:JisonServiceService){

  }

  analizar() {
    console.log(this.jisonServiceService.parse(this.areText))
  }

}
