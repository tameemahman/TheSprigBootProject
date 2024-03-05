import { Component, OnInit } from '@angular/core';
import { Product } from '../../model/product.model';
import { CartService } from '../../service/cart.service';
import { CartItem } from '../../model/cart-item.model';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.css'
})
export class CartComponent implements OnInit{

  cartItems: CartItem[] = [];

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
    this.loadCartItems();
  }

  loadCartItems(): void {
    this.cartItems = this.cartService.getCartItems();
  }

  removeFromCart(index: number): void {
    this.cartService.removeFromCart(index);
  }
}
