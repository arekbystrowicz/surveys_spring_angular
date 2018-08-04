import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SurevyListComponent } from './surevy-list.component';

describe('SurevyListComponent', () => {
  let component: SurevyListComponent;
  let fixture: ComponentFixture<SurevyListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SurevyListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SurevyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
