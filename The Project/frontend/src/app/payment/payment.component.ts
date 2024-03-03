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

  constructor(private formBuilder: FormBuilder) {
    this.paymentForm = this.formBuilder.group({
      // Define your form controls with validators if needed
      first_name: ['', Validators.required],
      last_name: ['', Validators.required],
      // Add more form controls as needed
    });
  }

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
