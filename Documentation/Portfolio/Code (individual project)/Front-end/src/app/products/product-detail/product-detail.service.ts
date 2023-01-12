import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../product";

@Injectable()
export class ProductDetailService {

  constructor(private http: HttpClient) {
  }

  async getProductById(id: number) {
    const url = 'api/products/id/' + id;
    return this.http.get(url);
  }

  async getMainCategoryByProductId(id: number): Promise<Observable<Product[]>>  {
    const url = 'api/products/main_category/' + id;
    return this.http.get<Product[]>(url)
  }
}
