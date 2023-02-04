import { PatentService } from 'src/app/SERVICE/patent.service';
import { JwtHelperService } from '@auth0/angular-jwt';

import { Injectable } from "@angular/core";
import { Router, ActivatedRouteSnapshot, CanActivate } from '@angular/router';

@Injectable({
    providedIn:'root'
})
export class RoleGuard implements CanActivate{
    constructor(
        private patentService:PatentService,
        private router:Router
    ){}

    canActivate(route:ActivatedRouteSnapshot):boolean{
        const expectedRoles: string = route.data.expectedRoles;
        const item = localStorage.getItem('user');
        const jwt: JwtHelperService = new JwtHelperService();

        const decodedItem = JSON.parse(item!);
        const info = jwt.decodeToken(decodedItem.accessToken);
        const roles: string[] = expectedRoles.split('|',2);

        if(roles.indexOf(info['roles'])===-1){
            this.router.navigate(['']);
            return false;
        }
        return true;
    }
}