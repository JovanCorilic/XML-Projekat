import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PretraziMetadataComponent } from './pretrazi-metadata.component';

describe('PretraziMetadataComponent', () => {
  let component: PretraziMetadataComponent;
  let fixture: ComponentFixture<PretraziMetadataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PretraziMetadataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PretraziMetadataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
