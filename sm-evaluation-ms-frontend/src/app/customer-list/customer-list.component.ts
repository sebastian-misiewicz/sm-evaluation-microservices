import {Component, OnInit} from '@angular/core';
import {CustomerListService} from "./customer-list.service";
import {Customer} from "../model/customer";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  providers: [CustomerListService],
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] = [];

  constructor(private customerListService: CustomerListService) {
  }

  ngOnInit(): void {
    this.getAllCustomers();
  }

  getAllCustomers(): void {
    this.customerListService.getAllCustomers()
      .subscribe(customers => (this.customers = customers));
  }

}
