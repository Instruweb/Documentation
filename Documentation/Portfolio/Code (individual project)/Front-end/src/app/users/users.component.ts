import {Component, OnInit} from '@angular/core';
import {UsersService} from "./users.service";
import {KeycloakService} from "keycloak-angular";
import {User} from "./user";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  providers: [UsersService],
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {
  loggedIn: boolean = false;
  user: User | undefined;

  constructor(
    private userService: UsersService,
    private keycloakservice: KeycloakService,
    private _snackBar: MatSnackBar) {
  }

  async ngOnInit() {
    this.loggedIn = await this.keycloakservice.isLoggedIn();

    if (this.loggedIn) {
      this.getUser();
    }
  }

  getUser() {
    this.keycloakservice.loadUserProfile().then(profile => {
      this.userService.getUser(profile.username)?.subscribe(res => {
        this.user = <User>res;
        this.user.firstname = profile.firstName;
        this.user.lastname = profile.lastName
        this.user.username = profile.username;
      }, error => {
        this._snackBar.open("The backend service is not available: " + error.statusText, 'OK', {
          duration: 5000,
          panelClass: ['errorSnackbar']
        });
      });
    });
  }

  updateUser(username: string, address: string, postalcode: string, phonenumber: string) {
    if (username && address && postalcode && phonenumber) {
      this.userService.updateUser(username, address, postalcode, phonenumber);
    }
  }

  async doLogin() {
    this.keycloakservice.login().then(r => console.log(r));
  }

  async doLogout() {
    this.keycloakservice.logout().then(r => console.log(r));
  }
}
