import { Injectable } from "@angular/core";

declare const Xonomy: any;

@Injectable({
    providedIn:'root'
})
export class XonomyLogin{
    constructor(){}

    public LoginSpecification = {
        elements:{
            'korisnik':{
                hasText:false
            },
                'korisnicko_ime':{
                    hasText:true
                },
                'lozinka':{
                    hasText:true
                },
                'uloga':{
                    isInvisible:true
                }
        }
    }
}