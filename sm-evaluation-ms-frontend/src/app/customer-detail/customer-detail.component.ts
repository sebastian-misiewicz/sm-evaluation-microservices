import { Component, OnInit } from '@angular/core';

import { Customer } from '../model/customer';
import { CustomerDetailService } from './customer-detail.service';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  providers: [CustomerDetailService],
  styleUrls: ['./customer-detail.component.scss']
})
export class CustomerDetailComponent implements OnInit {
  name = 'Tomek2';
  customer: Customer | undefined;

  constructor(private customerDetailService: CustomerDetailService) { }

  ngOnInit(): void {
    this.getCustomer(this.name);
  }

  getCustomer(customerName : string): void {
    this.customerDetailService.getCustomer(customerName)
      .subscribe(customer => (this.customer = customer));
  }

}
