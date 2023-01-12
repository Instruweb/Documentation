import {TestBed} from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {PageNotFoundComponent} from "./page-not-found.component";

describe('Page Not Found Component', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientTestingModule
      ],
      declarations: [
        PageNotFoundComponent
      ],
      providers: []
    }).compileComponents();
  });

  it('should create the component', () => {
    const fixture = TestBed.createComponent(PageNotFoundComponent);

    const app = fixture.componentInstance;

    expect(app).toBeTruthy();
  });

  it(`h2 should contain 'Page Not Found'`, () => {
    const fixture = TestBed.createComponent(PageNotFoundComponent);

    const app = fixture.nativeElement as HTMLElement;

    expect(app.querySelector('h2')?.textContent).toContain('Page Not Found');
  });
});
