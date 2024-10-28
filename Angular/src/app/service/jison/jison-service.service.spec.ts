import { TestBed } from '@angular/core/testing';

import { JisonServiceService } from './jison-service.service';

describe('JisonServiceService', () => {
  let service: JisonServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JisonServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
