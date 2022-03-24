import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CustomerDetailComponent} from './customer-detail/customer-detail.component';
import {MdbFormsModule} from "mdb-angular-ui-kit/forms";
import {MdbCollapseModule} from 'mdb-angular-ui-kit/collapse';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerFormComponent} from './customer-form/customer-form.component';
import {ErrorInterceptor} from "./http-error.interceptor";
import {LoginComponent} from './login/login.component';
import {NavigationComponent} from './navigation/navigation.component';
import {AuthInterceptor} from "./auth.interceptor";
import {LocalStorageService} from "./localstorage.service";

@NgModule({
  declarations: [
    AppComponent,
    CustomerDetailComponent,
    CustomerListComponent,
    CustomerFormComponent,
    LoginComponent,
    NavigationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MdbCollapseModule,
    MdbFormsModule,
    ReactiveFormsModule
  ],
  providers: [
    LocalStorageService,
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true, deps: [LocalStorageService] }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
