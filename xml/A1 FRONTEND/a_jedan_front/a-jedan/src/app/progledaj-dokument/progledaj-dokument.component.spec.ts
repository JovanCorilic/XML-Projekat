import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProgledajDokumentComponent } from './progledaj-dokument.component';

describe('ProgledajDokumentComponent', () => {
  let component: ProgledajDokumentComponent;
  let fixture: ComponentFixture<ProgledajDokumentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProgledajDokumentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProgledajDokumentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
