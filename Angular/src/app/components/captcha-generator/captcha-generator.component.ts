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
  line: number = 1;
  column: number = 1;
  userText: string = '';
  idCaptcha: string = '$elpepe';
  url: string = this.CAPTCHA_URL + this.idCaptcha ;
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
      this.userText,
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

  updatePosition(event: Event): void {
    const target = event.target as HTMLTextAreaElement;
    const position = target.selectionStart;
    const textUntilCursor = target.value.substring(0, position);
  
    this.line = textUntilCursor.split('\n').length;
    const lastLine = textUntilCursor.split('\n').pop() || '';
    this.column = lastLine.length + 1;
  }

  ///botones


  confirmacionAntesDeLimpiar(): boolean {
    if (this.userText) {
      return confirm('Tienes progreso sin guardar. ¿Estás seguro de que deseas borrar todo el contenido?');
    }
    return true;
  }
  
  // Nuevas funciones para los botones
  nuevoArchivo() {
    if (this.confirmacionAntesDeLimpiar()) {
      this.userText = ''; // Limpia el área de texto para un nuevo archivo
    }
  }

  abrirArchivo() {
    if (this.confirmacionAntesDeLimpiar()) {
      const input = document.createElement('input');
      input.type = 'file';
      input.accept = '.txt,.cc'; // Solo permite archivos de texto y .cc

      input.onchange = (e) => {
        const file = (e.target as HTMLInputElement).files?.[0];
        if (file) {
          const reader = new FileReader();
          reader.onload = (loadEvent) => {
            this.userText = loadEvent.target?.result as string; // Carga el contenido del archivo en userText
          };
          reader.readAsText(file); // Lee el archivo como texto
        }
      };

      input.click(); // Abre el diálogo de selección de archivos
    }
  }

  guardar() {
    if (this.userText) {
      const blob = new Blob([this.userText], { type: 'text/plain' });
      const link = document.createElement('a');
      link.href = URL.createObjectURL(blob);
      link.download = 'archivo_guardado.cc'; // Nombre predeterminado del archivo con extensión .cc
      link.click(); // Simula el clic para descargar
      alert('Archivo guardado exitosamente!'); // Mensaje de éxito
    } else {
      alert('No hay contenido para guardar.'); // Mensaje de error
    }
  }

  guardarComo() {
    const nombreArchivo = prompt("Ingresa el nombre para guardar el archivo:", "nuevo_archivo.cc");
    if (nombreArchivo && this.userText) {
      const blob = new Blob([this.userText], { type: 'text/plain' });
      const link = document.createElement('a');
      link.href = URL.createObjectURL(blob);
      link.download = nombreArchivo; // Nombre del archivo proporcionado por el usuario con extensión .cc
      link.click(); // Simula el clic para descargar
      alert(`Archivo guardado como ${nombreArchivo} exitosamente!`); // Mensaje de éxito
    } else {
      alert('No se puede guardar sin un nombre o sin contenido.'); // Mensaje de error
    }
  }
  
}
