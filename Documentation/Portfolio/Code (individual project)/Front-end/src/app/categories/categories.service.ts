import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Category} from "./category";
import {Observable} from "rxjs";

@Injectable()
export class CategoriesService {
  constructor(private http: HttpClient) {
  }

  getCategory(name: string) {
    name = name.trim();
    const url = '/api/categories/' + name;
    return this.http.get(url);
  }

  getAllCategories(): Observable<Category[]> {
    const url = '/api/categories/';
    return this.http.get<Category[]>(url);
  }
}
