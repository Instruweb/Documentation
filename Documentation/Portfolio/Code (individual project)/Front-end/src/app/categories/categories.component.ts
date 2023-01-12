import {Component, OnInit} from '@angular/core';
import {CategoriesService} from "./categories.service";
import {Category} from "./category";
import {KeycloakService} from "keycloak-angular";
import {Router} from "@angular/router";
import {UsersService} from "../users/users.service";
import {User} from "../users/user";

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  providers: [CategoriesService, UsersService],
  styleUrls: ['./categories.component.scss']
})
export class CategoriesComponent implements OnInit {
  hide: boolean = true;
  loggedIn: boolean = false;
  name: string = "";
  checkUsername: User | undefined;
  categories: Category[] = [];

  constructor(
    private categoriesService: CategoriesService,
    private userService: UsersService,
    private keycloakService: KeycloakService,
    private router: Router
  ) {
  }

  async ngOnInit() {
    this.router.routeReuseStrategy.shouldReuseRoute = () => { return false; };
    this.getAllCategories();
    this.loggedIn = await this.keycloakService.isLoggedIn();

    if (this.loggedIn) {
      this.checkUser();
    }
  }

  checkUser() {
    this.keycloakService.loadUserProfile().then(profile => {
      this.userService.getUser(profile.username)?.subscribe(res => {
        this.checkUsername = <User>res;

        if (profile.username == this.checkUsername?.username) {
          console.log('already in database');
        } else {
          this.userService.sendEmail(profile.email, profile.username);
        }
      }, error => {
        console.log("ERROR: ", error.statusText);

        if (profile.username == this.checkUsername?.username) {
          console.log('already in database');
        } else {
          this.userService.sendEmail(profile.email, profile.username);
        }
      });
    });
  }

  show() {
    this.hide = !this.hide;
  }

  async doLogin() {
    this.keycloakService.login().then(r => console.log(r));
  }

  getAllCategories(): void {
    this.categoriesService.getAllCategories().subscribe(
      categories => (this.categories = categories),
      error => {console.log()}
    );
  }

  searchCategory(term: string) {
    if (term) {
      this.categoriesService.getCategory(term).subscribe(res => {
        console.log('category: ', res)
      });
    }
  }

  refresh(): void {
    window.location.reload();
  }
}
