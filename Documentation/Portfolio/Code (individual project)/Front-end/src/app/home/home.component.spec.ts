import {TestBed} from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import {HomeComponent} from './home.component'
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {CategoriesService} from "../categories/categories.service";
import {MatSnackBarModule} from "@angular/material/snack-bar";

describe('HomeComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientTestingModule,
        MatSnackBarModule
      ],
      declarations: [
        HomeComponent
      ],
      providers: [
        CategoriesService
      ]
    }).compileComponents();
  });

  it('should create the component', () => {
    const fixture = TestBed.createComponent(HomeComponent);

    const app = fixture.componentInstance;

    expect(app).toBeTruthy();
  });

  it(`h1 should contain 'WELKOM OP INSTRUWEB'`, () => {
    const fixture = TestBed.createComponent(HomeComponent);

    const app = fixture.nativeElement as HTMLElement;

    expect(app.querySelector('h1')?.textContent).toContain('WELKOM OP INSTRUWEB');
  });
});
