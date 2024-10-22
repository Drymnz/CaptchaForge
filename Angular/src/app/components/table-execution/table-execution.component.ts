import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-table-execution',
  standalone: true,
  imports: [],
  templateUrl: './table-execution.component.html',
  styleUrl: './table-execution.component.css'
})
export class TableExecutionComponent {
  id!: string;

  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    // Usando snapshot (captura instantánea de los parámetros)
    this.id = this.route.snapshot.paramMap.get('id')!;
    console.log('ID:', this.id);
  }
}
