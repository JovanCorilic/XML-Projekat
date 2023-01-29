import { Injectable } from "@angular/core";

declare const Xonomy: any;

@Injectable({
    providedIn:'root'
})
export class XonomyViseMetapodatakaService{
    constructor(){}

    public ViseMetapodatakaSpecification = {
        elements:{
            'metapodaci':{
                hasText:false
            },
                'broj_prijave':{
                    hasText:true
                },
                'priznati_datum_podnosenja':{
                    hasText:true
                },
                'srpski_naziv':{
                    hasText:true
                },
                'engleski_naziv':{
                    hasText:true
                }
        }
    }
}