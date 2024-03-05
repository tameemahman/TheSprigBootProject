import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../services/payment.service';
import { ActivatedRoute, Router } from '@angular/router';
import { loadStripe, Stripe, StripeCardElement } from '@stripe/stripe-js';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  total: any;
  formData: any = {};
  stripe: Stripe | null = null;
  card: StripeCardElement | null = null;
  handler: any = null;

  constructor(private paymentService: PaymentService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.total = params.get('totalPrice');
      this.loadStripe();
    });

    this.loadStripe();

    console.log(this.total);
    this.initializeStripe();
  }

  async initializeStripe() {
    this.stripe = await loadStripe('your_stripe_publishable_key');
    if (this.stripe) {
      const elements = this.stripe.elements();
      this.card = elements.create('card');
      this.card.mount('#card-element');
    }
  }

  // async onSubmit() {
  //   if (this.stripe && this.card) {
  //     const { paymentMethod, error } = await this.stripe.createPaymentMethod({
  //       type: 'card',
  //       card: this.card,
  //     });

  //     if (error) {
  //       console.error(error);
  //     } else if (paymentMethod) {
  //       const userId = localStorage.getItem('user_id');
  //       const access_token = localStorage.getItem('access_token');

  //       if (userId !== null && access_token !== null) {
  //         this.paymentService.checkout(userId, access_token, paymentMethod.id).subscribe(
  //           (response) => {
  //             alert("Payment successful!");
  //             this.router.navigate(['/order']);
  //             console.log(response);
  //           },
  //           (error) => {
  //             console.error(error);
  //           }
  //         );
  //       }
  //     }
  //   }
  // }


  pay(amount: any) {

    var handler = (<any>window).StripeCheckout.configure({
      key: 'pk_test_51HxRkiCumzEESdU2Z1FzfCVAJyiVHyHifo0GeCMAyzHPFme6v6ahYeYbQPpD9BvXbAacO2yFQ8ETlKjo4pkHSHSh00qKzqUVK9',
      locale: 'auto',
      token: function (token: any) {
        // You can access the token ID with `token.id`.
        // Get the token ID to your server-side code for use.
        console.log(token)
        alert('Token Created!!');
      }
    });

    handler.open({
      name: 'Payment method',
      description: '2 widgets',
      amount: amount * 100
    });

  }

  loadStripe() {

    if (!window.document.getElementById('stripe-script')) {
      var s = window.document.createElement("script");
      s.id = "stripe-script";
      s.type = "text/javascript";
      s.src = "https://checkout.stripe.com/checkout.js";
      s.onload = () => {
        this.handler = (<any>window).StripeCheckout.configure({
          key: 'pk_test_51HxRkiCumzEESdU2Z1FzfCVAJyiVHyHifo0GeCMAyzHPFme6v6ahYeYbQPpD9BvXbAacO2yFQ8ETlKjo4pkHSHSh00qKzqUVK9',
          locale: 'auto',
          token: function (token: any) {
            // You can access the token ID with `token.id`.
            // Get the token ID to your server-side code for use.
            console.log(token);
            alert('Payment Successful!');
          }
        });
      }


      window.document.body.appendChild(s);
    }
  }



  // Implement this method to handle the form submission
  submitPaymentForm() {
    // Handle form submission here
  }
}
