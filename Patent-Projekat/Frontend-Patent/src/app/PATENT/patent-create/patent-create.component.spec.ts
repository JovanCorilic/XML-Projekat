import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PatentCreateComponent } from './patent-create.component';

describe('PatentCreateComponent', () => {
  let component: PatentCreateComponent;
  let fixture: ComponentFixture<PatentCreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PatentCreateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PatentCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
