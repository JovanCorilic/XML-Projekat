import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SviPatentComponent } from './svi-patent.component';

describe('SviPatentComponent', () => {
  let component: SviPatentComponent;
  let fixture: ComponentFixture<SviPatentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SviPatentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SviPatentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
