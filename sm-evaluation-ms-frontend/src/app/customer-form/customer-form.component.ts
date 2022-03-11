import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {CustomerService} from "../customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  providers: [CustomerService],
  styleUrls: ['./customer-form.component.scss']
})
export class CustomerFormComponent implements OnInit {

  customerFormGroup = this.formBuilder.group({
    name: '',
    email: ''
  });

  constructor(private formBuilder: FormBuilder, private customerFormService: CustomerService, private router: Router) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log('Your order has been submitted', this.customerFormGroup.value);
    this.customerFormService.addCustomer(this.customerFormGroup.value)//
      .subscribe(customer => {
        this.customerFormGroup.reset();
        console.log('Created :', customer);
        this.router.navigate(['customer-list']);
      });

    ;
  }

}
