import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaptchaUsageReportComponent } from './captcha-usage-report.component';

describe('CaptchaUsageReportComponent', () => {
  let component: CaptchaUsageReportComponent;
  let fixture: ComponentFixture<CaptchaUsageReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CaptchaUsageReportComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaptchaUsageReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
