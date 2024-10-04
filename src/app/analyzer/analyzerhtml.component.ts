import {  ChangeDetectionStrategy, Component } from '@angular/core';
import {  FormsModule  } from '@angular/forms';

@Component({
  selector: 'app-analyzerhtml',
  standalone: true,
  changeDetection:ChangeDetectionStrategy.OnPush,
  imports: [FormsModule],
  templateUrl: './analyzerhtml.component.html',
  styleUrl: './analyzerhtml.component.css'
})

export class AnalyzerhtmlComponent {
  texto: string = '';

  analizar(){
    console.log(this.texto);
    alert(this.texto);
  }
}
``