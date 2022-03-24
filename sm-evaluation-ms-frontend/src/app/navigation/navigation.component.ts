import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {LocalStorageService} from "../localstorage.service";

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  providers: [LocalStorageService],
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  constructor(private router: Router, private localStorageService: LocalStorageService) { }

  ngOnInit(): void {
  }

  onLoginClick(): void {
    this.router.navigate(['login']);
  }

  isUserLoggedIn(): boolean {
    return this.localStorageService.hasJWTToken();
  }

  onLogoutClick() {
    this.localStorageService.clearJWTToken();
    this.router.navigate(['login']);
  }
}
