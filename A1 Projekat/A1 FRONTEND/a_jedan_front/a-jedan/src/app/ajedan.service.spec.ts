import { TestBed } from '@angular/core/testing';

import { AjedanService } from './ajedan.service';

describe('AjedanService', () => {
  let service: AjedanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AjedanService);
  });

  it('should be created', () => {
    const service: AjedanService = TestBed.get(AjedanService);
    expect(service).toBeTruthy();
  });
});
