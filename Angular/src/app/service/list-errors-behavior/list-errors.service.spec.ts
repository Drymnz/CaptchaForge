import { TestBed } from '@angular/core/testing';

import { ListErrorsService } from './list-errors.service';

describe('ListErrorsService', () => {
  let service: ListErrorsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListErrorsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
