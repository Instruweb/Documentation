import {TestBed} from '@angular/core/testing';
import {RouterTestingModule} from '@angular/router/testing';
import {CategoriesComponent} from './categories.component'
import {HttpClientTestingModule} from "@angular/common/http/testing";
import {CategoriesService} from "./categories.service";
import {KeycloakService} from "keycloak-angular";
import {UsersService} from "../users/users.service";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSnackBarModule} from "@angular/material/snack-bar";

describe('CategoriesComponent', () => {
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
        CategoriesComponent
      ],
      providers: [
        CategoriesService,
        {provide: KeycloakService, UsersService}
      ]
    }).compileComponents();
  });

  it('should create the component', () => {
    const fixture = TestBed.createComponent(CategoriesComponent);

    const app = fixture.componentInstance;

    expect(app).toBeTruthy();
  });

  it(`should be logged out as default'`, () => {
    const fixture = TestBed.createComponent(CategoriesComponent);

    const app = fixture.componentInstance;

    expect(app.loggedIn).toEqual(false);
  });
});
