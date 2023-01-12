import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "./product";

@Injectable()
export class ProductsService {

  constructor(private http: HttpClient) {
  }

  async getProduct(name: string) {
    name = name.trim();
    const url = '/api/products/' + name;
    return this.http.get(url);
  }

  async getAllProducts(): Promise<Observable<Product[]>> {
    const url = '/api/products/';
    return this.http.get<Product[]>(url);
  }

  getProductsByMainCategoryId(id: number): Observable<Product[]> {
    const url = '/api/products/main_category/' + id;
    return this.http.get<Product[]>(url);
  }
}
