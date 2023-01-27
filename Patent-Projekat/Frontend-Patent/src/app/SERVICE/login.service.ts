import { PatentService } from 'src/app/SERVICE/patent.service';

import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
@Injectable({
    providedIn:'root'
})
export class LoginGuard implements CanActivate{
    constructor(
        private patentService:PatentService,
        private router:Router
    ){}

    canActivate():boolean{
        if (this.patentService.isLoggedIn()){
            this.router.navigate([' ']);
            return false;
        }
        return true;
    }
}