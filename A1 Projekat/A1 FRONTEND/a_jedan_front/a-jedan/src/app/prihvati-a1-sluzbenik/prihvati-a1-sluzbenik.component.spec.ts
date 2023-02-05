import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrihvatiA1SluzbenikComponent } from './prihvati-a1-sluzbenik.component';

describe('PrihvatiA1SluzbenikComponent', () => {
  let component: PrihvatiA1SluzbenikComponent;
  let fixture: ComponentFixture<PrihvatiA1SluzbenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrihvatiA1SluzbenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrihvatiA1SluzbenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
