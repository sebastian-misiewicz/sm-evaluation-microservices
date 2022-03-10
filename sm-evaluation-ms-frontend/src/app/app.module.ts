import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {CustomerDetailComponent} from './customer-detail/customer-detail.component';
import {MdbFormsModule} from "mdb-angular-ui-kit/forms";
import {MdbCollapseModule} from 'mdb-angular-ui-kit/collapse';
import {CustomerListComponent} from './customer-list/customer-list.component';
import {CustomerFormComponent} from './customer-form/customer-form.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerDetailComponent,
    CustomerListComponent,
    CustomerFormComponent
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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
