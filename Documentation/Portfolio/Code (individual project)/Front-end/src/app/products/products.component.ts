import {Component, OnInit} from '@angular/core';
import {ProductsService} from "./products.service";
import {ActivatedRoute} from "@angular/router";
import {Product} from "./product";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  providers: [ProductsService],
  styleUrls: ['./products.component.scss']
})
export class ProductsComponent implements OnInit {
  errorMessage: string = "";
  name: string = "";
  id: number = 0;
  productsByCategory: Product[] = [];
  foundProduct: Product | undefined;

  constructor(
    private productsService: ProductsService,
    private _ActivatedRoute: ActivatedRoute,
    private _snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this._ActivatedRoute.params.subscribe((params: { [x: string]: string | number; }) => {
      this.id = +params['id'];
    });
    this.getProductsByMainCategoryId(this.id);
  }

  async searchProduct(term: string) {
    if (term) {
      (await this.productsService.getProduct(term))
        .subscribe(res => {
            this.foundProduct = <Product>res;
            this.errorMessage = "";
          },
          error => {
            this.errorMessage = "ERROR: " + error.statusText;
            this.foundProduct = undefined;
          }
        );
    }
  }

  getProductsByMainCategoryId(id: number): void {
    this.productsService.getProductsByMainCategoryId(id).subscribe(
      products => (this.productsByCategory = products),
      error => {
        this._snackBar.open("The backend service is not available: " + error.statusText, 'OK', {
          duration: 5000,
          panelClass: ['errorSnackbar']
        })
      }
    );
  }

  clear() {
    this.foundProduct = undefined;
  }
}
