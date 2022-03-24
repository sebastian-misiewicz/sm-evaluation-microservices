import {Injectable} from '@angular/core';
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';
import {LocalStorageService} from "./localstorage.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(private localStorageService: LocalStorageService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const isApiUrl = request.url.startsWith(environment.API_URL) || request.url.startsWith(environment.API_COMMAND_URL);
    const jwtToken = this.localStorageService.get('jwtToken');
    if (isApiUrl) {
      request = request.clone({

        setHeaders: {
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
          'Content-Type': 'application/json; charset=utf-8',
          'Accept': 'application/json',
          'Authorization': 'Bearer ' + jwtToken
        },
      });
    }

    return next.handle(request);
  }
}
