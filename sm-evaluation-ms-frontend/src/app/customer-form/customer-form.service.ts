import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import {Customer} from '../model/customer';
import {catchError, Observable} from 'rxjs';
import {environment} from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class CustomerFormService {
  customerDetailUrl = environment.API_COMMAND_URL + 'customer';  // URL to web api

  constructor(
    private http: HttpClient) {
  }

  addCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(this.customerDetailUrl, customer, httpOptions);
  }
}
