import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {CustomerListComponent} from "./customer-list/customer-list.component";
import {CustomerFormComponent} from "./customer-form/customer-form.component";
import {LoginComponent} from "./login/login.component";

const routes: Routes = [
  { path: '', redirectTo: '/customer-list', pathMatch: 'full' },
  { path: 'customer-list', component: CustomerListComponent },
  { path: 'customer-add', component: CustomerFormComponent },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
