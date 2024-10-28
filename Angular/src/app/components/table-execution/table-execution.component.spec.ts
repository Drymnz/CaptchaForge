import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableExecutionComponent } from './table-execution.component';

describe('TableExecutionComponent', () => {
  let component: TableExecutionComponent;
  let fixture: ComponentFixture<TableExecutionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TableExecutionComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableExecutionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
