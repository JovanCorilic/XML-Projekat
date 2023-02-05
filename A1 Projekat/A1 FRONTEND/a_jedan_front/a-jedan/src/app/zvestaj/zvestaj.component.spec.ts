import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZvestajComponent } from './zvestaj.component';

describe('ZvestajComponent', () => {
  let component: ZvestajComponent;
  let fixture: ComponentFixture<ZvestajComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZvestajComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ZvestajComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
