import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import {CategoriesComponent} from "./categories/categories.component";
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {CategoriesService} from "./categories/categories.service";
import {KeycloakService} from "keycloak-angular";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSnackBarModule} from "@angular/material/snack-bar";

describe('AppComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientTestingModule,
        MatIconModule,
        MatToolbarModule,
        MatSnackBarModule
      ],
      declarations: [
        AppComponent,
        CategoriesComponent
      ],
      providers: [
        CategoriesService,
        {provide: KeycloakService}
      ]
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);

    const app = fixture.componentInstance;

    expect(app).toBeTruthy();
  });

  it(`should have as title 'Instruweb'`, () => {
    const fixture = TestBed.createComponent(AppComponent);

    const app = fixture.componentInstance;

    expect(app.title).toEqual('Instruweb');
  });
});
