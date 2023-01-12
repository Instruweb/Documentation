import {Component, OnInit} from '@angular/core';
import {ProductDetailService} from "./product-detail.service";
import {ActivatedRoute} from "@angular/router";
import {Product} from "../product";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  providers: [ProductDetailService],
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {
  errorMessage: string = "";
  id: number = 0;
  product: Product | undefined;
  productsByMainCategory: Product[] = [];

  constructor(
    public productDetailService: ProductDetailService,
    private _ActivatedRoute: ActivatedRoute,
    private _snackBar: MatSnackBar) {
  }

  async ngOnInit() {
    this._ActivatedRoute.params.subscribe((params: { [x: string]: string | number; }) => {
      this.id = +params['id'];
    });
    await this.getProductById(this.id);
  }

  async getProductById(id: number) {
    (await this.productDetailService.getProductById(id))
      .subscribe(res => {
          this.product = <Product>res;
          this.getMainCategoryByProductId(this.product.main_categoryId);
          this.errorMessage = "";
        },
        error => {
          this.errorMessage = "ERROR: " + error.statusText;
          this.product = undefined;
          this._snackBar.open("The backend service is not available: " + error.statusText, 'OK', {
            duration: 5000,
            panelClass: ['errorSnackbar']
          })
        }
      )
  }

  async getMainCategoryByProductId(id: number) {
    if (id) {
      (await this.productDetailService.getMainCategoryByProductId(id))?.subscribe(res => {
        this.productsByMainCategory = res;
      });
    }
  }
}
