import { TestBed } from '@angular/core/testing';

import { FilesComponentService } from './files-component.service';

describe('FilesComponentService', () => {
  let service: FilesComponentService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FilesComponentService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
