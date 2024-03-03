import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-payment-form',
  templateUrl: './payment-form.component.html',
  styleUrls: ['./payment-form.component.css']
})
export class PaymentFormComponent implements OnInit {
  billingForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.billingForm = this.formBuilder.group({
      first_name: ['', Validators.required],
      last_name: ['', Validators.required],
      country: [{value: 'Bangladesh', disabled: true}],
      address_line1: ['', Validators.required],
      address_line2: [''],
      postcode: ['', Validators.required],
      city: [{value: 'Dhaka', disabled: true}],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      additional_info: [''],
      amount_payable: ['', Validators.required],
      shipping: [{value: 'Pathao', disabled: true}],
      total_amount: ['', Validators.required]
    });
  }

  submitForm() {
    if (this.billingForm.valid) {
      // Process form submission
      console.log(this.billingForm.value);
    }
  }
}
