import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../customer.service";
import {Customer} from "../model/customer";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  providers: [CustomerService],
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] = [];

  constructor(private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.getAllCustomers();
  }

  getAllCustomers(): void {
    this.customerService.getAllCustomers()
      .subscribe(customers => (this.customers = customers));
  }

  delete(customer: Customer): void {
    this.customerService.deleteCustomer(customer).subscribe(customer => this.getAllCustomers());
  }

}
