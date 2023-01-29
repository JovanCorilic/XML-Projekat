import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateResenjeComponent } from './create-resenje.component';

describe('CreateResenjeComponent', () => {
  let component: CreateResenjeComponent;
  let fixture: ComponentFixture<CreateResenjeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateResenjeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateResenjeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
