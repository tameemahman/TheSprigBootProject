import { Component } from '@angular/core';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {
total: any;

  constructor() { }

  submitPaymentForm() {
    // Implement your payment processing logic here
    console.log('Payment submitted');
    // You can send payment data to your server, call payment gateway APIs, etc.
  }

}
