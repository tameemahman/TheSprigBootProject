import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  private baseUrl = 'http://localhost:8080'; // Replace with your Spring Boot backend URL

  private handleErrorObservable(error: any): Observable<any> {
    console.error('An error occurred:', error);
    // You can return an Observable here, for example:
    return throwError('An error occurred'); // throwError is imported from 'rxjs'
  }

  constructor(private http: HttpClient) { }

  submitPaymentForm(formData: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/submitPaymentForm`, formData)
      .pipe(
        catchError(this.handleErrorObservable)
      );
  }

}
