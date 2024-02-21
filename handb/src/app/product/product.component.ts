import { Component, OnInit } from '@angular/core';

import { ProductService } from '../service/product.service';
import { Category, Product } from '../model/product.model';
import { HttpClient } from '@angular/common/http';
// import { ProductService } from './product.service'; // Import ProductService
// import { Product } from './product.model'; // Import Product model

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductsComponent implements OnInit {
    products: any[] = [];
$index: any;
product: any;
  
    constructor(private http: HttpClient) { }
  
    ngOnInit() {
      this.fetchProducts();
    }
  
    fetchProducts() {
      this.http.get<any[]>('http://localhost:8085/api/product')
        .subscribe(products => {
          this.products = products;
        });
    }
}
