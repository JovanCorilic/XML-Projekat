import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledA1SluzbenikComponent } from './pregled-a1-sluzbenik.component';

describe('PregledA1SluzbenikComponent', () => {
  let component: PregledA1SluzbenikComponent;
  let fixture: ComponentFixture<PregledA1SluzbenikComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PregledA1SluzbenikComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PregledA1SluzbenikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
