import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { ReportErrorInterpreter } from '../../model/Analyzer/ReportErrorInterpreter';
import { ListErrorsService } from '../../core/service/list-errors.service';
import { CommonModule } from '@angular/common';
import { Token } from '../../model/Analyzer/Token';
import { ErrorTypeInTheInterpreter } from '../../model/Analyzer/ErrorTypeInTheInterpreter';

@Component({
  selector: 'app-error-listing',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './error-listing.component.html',
  styleUrl: './error-listing.component.css',
})
export class ErrorListingComponent {
  listArray: ReportErrorInterpreter[] = [];

  constructor(private listErros: ListErrorsService) {
    this.listErros.getListErroresObservable().subscribe((data) =>
      data.forEach((element) => {
        const reportErrorInterpreter = ReportErrorInterpreter.fromJSON(element);
        this.listArray.push(reportErrorInterpreter);
      })
    );
  }
}
