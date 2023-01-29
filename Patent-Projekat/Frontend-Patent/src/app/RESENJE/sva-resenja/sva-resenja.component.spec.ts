import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SvaResenjaComponent } from './sva-resenja.component';

describe('SvaResenjaComponent', () => {
  let component: SvaResenjaComponent;
  let fixture: ComponentFixture<SvaResenjaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SvaResenjaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SvaResenjaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
