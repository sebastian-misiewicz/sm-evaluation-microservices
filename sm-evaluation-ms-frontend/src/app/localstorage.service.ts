import { Injectable } from '@angular/core';

@Injectable()
export class LocalStorageService {

  set(key: string, value: string) {
    localStorage.setItem(key, value);
  }

  get(key: string) {
    return localStorage.getItem(key);
  }

  remove(key: string) {
    localStorage.removeItem(key);
  }

  hasJWTToken() : boolean {
    return this.get('jwtToken') != null;
  }

  clearJWTToken() {
    this.remove('jwtToken');
  }
}
