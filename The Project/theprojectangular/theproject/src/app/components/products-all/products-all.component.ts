import { Component, OnInit } from '@angular/core';
import { Product } from '../../model/product.model';
import { ProductService } from '../../service/product.service';
import { Router } from '@angular/router';
import { CartService } from '../../service/cart.service';
import { CartItem } from '../../model/cart-item.model';

@Component({
  selector: 'app-products-all',
  templateUrl: './products-all.component.html',
  styleUrl: './products-all.component.css'
})
export class ProductsAllComponent implements OnInit{
  products: Product[] = [];

  constructor(
    private productService: ProductService,
    private router: Router,
    private cartService: CartService
  ) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts(): void {
    this.productService.getAllProducts()
      .subscribe(products => this.products = products);
  }

  addToCart(product: Product): void {
    const cartItem: CartItem = {
      productId: product.id!,
      productName: product.name!,
      quantity: 1, // You can set the quantity as needed
      price: product.price!
    };
    this.cartService.addToCart(cartItem);
    this.router.navigate(['/cart']);
  }
  
}
