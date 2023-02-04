import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PretragaViseMetapodatakaComponent } from './pretraga-vise-metapodataka.component';

describe('PretragaViseMetapodatakaComponent', () => {
  let component: PretragaViseMetapodatakaComponent;
  let fixture: ComponentFixture<PretragaViseMetapodatakaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PretragaViseMetapodatakaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PretragaViseMetapodatakaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
