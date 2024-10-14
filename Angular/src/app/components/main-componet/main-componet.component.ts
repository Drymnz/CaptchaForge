import { Component } from '@angular/core';
import { NavbarComponent } from '../navbar/navbar.component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-main-componet',
  standalone: true,
  imports: [NavbarComponent,RouterOutlet],
  templateUrl: './main-componet.component.html',
  styleUrl: './main-componet.component.css'
})
export class MainComponetComponent {

}
