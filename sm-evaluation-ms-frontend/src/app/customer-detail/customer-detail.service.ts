import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http';
import {Customer} from './customer';
import {Observable} from 'rxjs';
import { environment } from '../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class CustomerDetailService {
  customerDetailUrl = environment.API_URL + 'customer';  // URL to web api

  constructor(
    private http: HttpClient) {
  }

  getCustomer(name: string): Observable<Customer> {
    name = name.trim();
    const options = name ?
      {params: new HttpParams().set('name', name)} : {};
    return this.http.get<Customer>(this.customerDetailUrl, options);
  }
}
