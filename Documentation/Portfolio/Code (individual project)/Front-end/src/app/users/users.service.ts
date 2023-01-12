import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {API_HEADERS} from "../../url.constants";
import {KeycloakService} from "keycloak-angular";

@Injectable()
export class UsersService {
    constructor(private http: HttpClient, private keycloakService: KeycloakService) {
    this.setHeaders().then(r => console.log(r));
  }

  async setHeaders() {
    if (await this.keycloakService.getToken() != undefined) {
      API_HEADERS.headers = API_HEADERS.headers.set('Authorization', 'Bearer ' + await this.keycloakService.getToken());
      return "Success";
    }
    return "Logged out";
  }

  getUser(emailaddress: string | undefined) {
    if (emailaddress) {
      emailaddress = emailaddress.trim();
      const url = '/api/users/' + emailaddress;
      return this.http.get(url, API_HEADERS);
    }
    throw new Error("An error occurred.");
  }

  sendEmail(emailaddress: string | undefined, username: string | undefined) {
    if (emailaddress) {
      emailaddress = emailaddress.trim();
      const url = '/api/users/register/' + username + "/" + emailaddress;
      return this.http.post<any>(url, {headers: API_HEADERS.headers}).subscribe(data => console.log("Added"))
    }
    throw new Error("An error occurred.");
  }

  updateUser(username: string, address: string, postalcode: string, phonenumber: string) {
    if (username && address && postalcode && phonenumber) {
      const url = '/api/users/update/' + username + "/" + postalcode + "/" + address + "/" + phonenumber;
      return this.http.put<any>(url, {headers: API_HEADERS.headers}).subscribe(data => console.log("Updated"))
    }
    throw new Error("An error occurred.");
  }
}
