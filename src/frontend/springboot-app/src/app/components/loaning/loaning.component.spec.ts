import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoaningComponent } from './loaning.component';

describe('LoaningComponent', () => {
  let component: LoaningComponent;
  let fixture: ComponentFixture<LoaningComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoaningComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoaningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
