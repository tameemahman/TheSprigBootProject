import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { Category } from '../model/category.model';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  private baseUrl = 'http://localhost:8080/categories'; // Update the URL accordingly

  constructor(private http: HttpClient) { }

  getAllCategories(): Observable<Category[]> {
    return this.http.get<Category[]>(this.baseUrl)
      .pipe(
        catchError(this.handleError)
      );
  }

  getCategoryById(id: number): Observable<Category> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Category>(url)
      .pipe(
        catchError(this.handleError)
      );
  }

  createCategory(category: Category): Observable<Category> {
    return this.http.post<Category>(this.baseUrl, category)
      .pipe(
        catchError(this.handleError)
      );
  }

  updateCategory(id: number, category: Category): Observable<Category> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.put<Category>(url, category)
      .pipe(
        catchError(this.handleError)
      );
  }

  deleteCategory(id: number): Observable<void> {
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
