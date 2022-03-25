import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import {Customer} from './model/customer';
import {catchError, Observable} from 'rxjs';
import {environment} from '../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class CustomerService {
  customerApi = environment.API_URL + 'customer';

  constructor(
    private http: HttpClient) {
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.customerApi, customer, httpOptions);
  }

  deleteCustomer(customer: Customer): Observable<Customer> {
    return this.http.delete<Customer>(this.customerApi + '/' + customer.id, httpOptions);
  }

  getAllCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.customerApi);
  }
}
