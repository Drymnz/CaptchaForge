import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AnalyzerhtmlComponent } from "./analyzer/analyzerhtml.component";


@Component({
  selector: 'app-root',
  changeDetection:ChangeDetectionStrategy.OnPush,
  standalone: true,
  imports: [RouterOutlet, AnalyzerhtmlComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})

export class AppComponent {
  title = 'CaptchaForge';
}
