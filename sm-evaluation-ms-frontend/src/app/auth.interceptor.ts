import {Injectable} from '@angular/core';
import {
  HttpEvent,
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
  HttpErrorResponse,
  HttpResponse
} from '@angular/common/http';
import {catchError, Observable, throwError} from 'rxjs';
import {environment} from '../environments/environment';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const isApiUrl = request.url.startsWith(environment.API_URL) || request.url.startsWith(environment.API_COMMAND_URL);
    if (isApiUrl) {
      request = request.clone({

        setHeaders: {
          'Access-Control-Allow-Origin': '*',
          'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept',
          'Content-Type': 'application/json; charset=utf-8',
          'Accept': 'application/json',
          'Authorization': 'Basic amFuLmtvd2Fsc2tpOnBhc3N3b3Jk'
        },
      });
    }

    return next.handle(request);
  }
}
