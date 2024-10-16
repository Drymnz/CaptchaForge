import { TestBed } from '@angular/core/testing';
import { ApiAnalizerService } from './api-analizer.service';


describe('ApiAnalizerService', () => {
  let service: ApiAnalizerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ApiAnalizerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
