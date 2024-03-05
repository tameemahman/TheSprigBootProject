import { Injectable } from '@angular/core';
import { Product } from '../model/product.model';
import { CartItem } from '../model/cart-item.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  cartItems: CartItem[] = [];

  constructor() { }

  addToCart(item: CartItem): void {
    this.cartItems.push(item);
  }

  removeFromCart(index: number): void {
    this.cartItems.splice(index, 1);
  }

  getCartItems(): CartItem[] {
    return this.cartItems;
  }
}
