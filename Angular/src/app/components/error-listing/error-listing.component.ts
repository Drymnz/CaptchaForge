import { Component } from '@angular/core';
import { ReportErrorInterpreter } from '../../model/Analyzer/ReportErrorInterpreter';
import { CommonModule } from '@angular/common';
import { ListErrorsService } from '../../service/list-errors-behavior/list-errors.service';

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
