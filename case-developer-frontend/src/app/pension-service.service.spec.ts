import { TestBed } from '@angular/core/testing';

import { PensionService } from './pension.service';

describe('PensionServiceService', () => {
  let service: PensionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PensionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
