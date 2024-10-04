import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalyzerhtmlComponent } from './analyzerhtml.component';

describe('AnalyzerhtmlComponent', () => {
  let component: AnalyzerhtmlComponent;
  let fixture: ComponentFixture<AnalyzerhtmlComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AnalyzerhtmlComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnalyzerhtmlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
