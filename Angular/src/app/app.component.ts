import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { MainComponetComponent } from './components/main-componet/main-componet.component';


@Component({
  selector: 'app-root',
  changeDetection:ChangeDetectionStrategy.OnPush,
  standalone: true,
  imports: [RouterOutlet,MainComponetComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export   class AppComponent {
  title = 'CaptchaForge';
  
  ngOnInit() {
    /* import('../assets/Calculadora.js').then(() => {
      console.log('Script cargado exitosamente.');
    }); */
  }
}
