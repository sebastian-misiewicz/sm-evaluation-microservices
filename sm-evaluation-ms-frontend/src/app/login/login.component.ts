import {Component, OnInit} from '@angular/core';
import {FormBuilder} from "@angular/forms";
import {Router} from "@angular/router";
import {LocalStorageService} from "../localstorage.service";
import {AuthenticateService} from "../authenticate.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  providers: [AuthenticateService, LocalStorageService],
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginFormGroup = this.formBuilder.group({
    username: '',
    password: ''
  });

  hasLoginFailed: Boolean = false;

  constructor(private formBuilder: FormBuilder, private router: Router, private localStorageService: LocalStorageService, private authorizationService: AuthenticateService) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log('Logged in:', this.loginFormGroup.value);
    const _this = this;

    this.authorizationService.login(this.loginFormGroup.value).subscribe({
      next(jwtToken) {
        console.log(jwtToken);
        _this.hasLoginFailed = false;
        _this.localStorageService.set('jwtToken', jwtToken.jwtToken);
        _this.router.navigate(['customer-list']);
      },
      error(msg) {
        _this.hasLoginFailed = true;
      }
    });

    // this.router.navigate(['customer-list']);
  }

}
