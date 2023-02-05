import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GradjaninComponent } from './gradjanin.component';

describe('GradjaninComponent', () => {
  let component: GradjaninComponent;
  let fixture: ComponentFixture<GradjaninComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GradjaninComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GradjaninComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
