import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrihvatiOdabravniA1SluzbenikComponent } from './prihvati-odabravni-a1-sluzbenik.component';

describe('PrihvatiOdabravniA1SluzbenikComponent', () => {
  let component: PrihvatiOdabravniA1SluzbenikComponent;
  let fixture: ComponentFixture<PrihvatiOdabravniA1SluzbenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrihvatiOdabravniA1SluzbenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrihvatiOdabravniA1SluzbenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

});
