import { Component, } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent {

  paymentForm: FormGroup;
  paymentService: any;
total: any;

<<<<<<< HEAD
  constructor(private formBuilder: FormBuilder) {
    this.paymentForm = this.formBuilder.group({
      // Define your form controls with validators if needed
      first_name: ['', Validators.required],
      last_name: ['', Validators.required],
      // Add more form controls as needed
    });
  }
=======
  constructor(private paymentService: PaymentService, private router: Router) {}

  async ngOnInit() {
    this.stripe = await loadStripe('your_stripe_publishable_key');
    if (this.stripe) {
        const elements = this.stripe.elements();
        this.card = elements.create('card');
        this.card.mount('#card-element');
    }
}
>>>>>>> 88f6dabaffd1f83074ef5707a60f1ebd121e0043

  submitPaymentForm() {
    if (this.paymentForm.valid) {
      this.paymentService.submitPaymentForm(this.paymentForm.value)
        .subscribe(
          (          response: any) => {
            // Handle success response
            console.log(response);
          },
          (          error: any) => {
            // Handle error response
            console.error(error);
          }
        );
    }
  }
}
