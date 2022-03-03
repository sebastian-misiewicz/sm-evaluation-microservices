import { Component, OnInit } from '@angular/core';

import { Customer } from './customer';
import { CustomerDetailService } from './customer-detail.service';

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  providers: [CustomerDetailService],
  styleUrls: ['./customer-detail.component.less']
})
export class CustomerDetailComponent implements OnInit {

  name = 'Tomek2';
  customer: Customer | undefined;

  constructor(private customerDetailService: CustomerDetailService) { }

  ngOnInit(): void {
    this.getCustomer();
  }

  getCustomer(): void {
    this.customerDetailService.getCustomer(this.name)
      .subscribe(customer => (this.customer = customer));
  }

}
