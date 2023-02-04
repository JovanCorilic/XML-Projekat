import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditResenjeComponent } from './edit-resenje.component';

describe('EditResenjeComponent', () => {
  let component: EditResenjeComponent;
  let fixture: ComponentFixture<EditResenjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditResenjeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditResenjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
