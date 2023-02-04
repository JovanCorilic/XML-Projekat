import { Injectable } from "@angular/core";

declare const Xonomy: any;

@Injectable({
    providedIn:'root'
})
export class XonomyRegistracija{
    constructor(){}

    public RegistracijaSpecification = {
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
                    hasText:true,
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "CITIZEN", caption: "Građanin"},{value: "EMPLOYEE", caption: "Službenik"}]
                }
        }
    }
}