import { SecurityService } from './security.service';


import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
@Injectable({
    providedIn:'root'
})
export class LoginGuard implements CanActivate{
    constructor(
        private securityService:SecurityService,
        private router:Router
    ){}

    canActivate():boolean{
        if (this.securityService.isLoggedIn()){
            this.router.navigate([' ']);
            return false;
        }
        return true;
    }
}