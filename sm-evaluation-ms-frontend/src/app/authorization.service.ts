import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';
import {JWTToken} from "./model/jwttoken";
import {Login} from "./model/login";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable()
export class AuthorizationService {
  customerCommandApi = environment.API_AUTH_URL + 'authenticate';

  constructor(
    private http: HttpClient) {
  }

  login(login: Login): Observable<JWTToken> {
    return this.http.post<JWTToken>(this.customerCommandApi, login, httpOptions);
  }

}
