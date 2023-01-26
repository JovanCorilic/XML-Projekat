import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPatentComponent } from './edit-patent.component';

describe('EditPatentComponent', () => {
  let component: EditPatentComponent;
  let fixture: ComponentFixture<EditPatentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditPatentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditPatentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
