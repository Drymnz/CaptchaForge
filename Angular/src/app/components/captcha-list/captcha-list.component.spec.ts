import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaptchaListComponent } from './captcha-list.component';

describe('CaptchaListComponent', () => {
  let component: CaptchaListComponent;
  let fixture: ComponentFixture<CaptchaListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CaptchaListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CaptchaListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
