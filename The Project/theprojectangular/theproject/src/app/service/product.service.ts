import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Product } from '../model/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/products'; // Update the URL accordingly

  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.baseUrl)
      .pipe(
        catchError(this.handleError)
      );
  }

  getProductById(id: number): Observable<Product> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Product>(url)
      .pipe(
        catchError(this.handleError)
      );
  }

  createProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(this.baseUrl, product)
      .pipe(
        catchError(this.handleError)
      );
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.put<Product>(url, product)
      .pipe(
        catchError(this.handleError)
      );
  }

  deleteProduct(id: number): Observable<void> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: any) {
    console.error('An error occurred:', error);
    return throwError(error);
  }
}
