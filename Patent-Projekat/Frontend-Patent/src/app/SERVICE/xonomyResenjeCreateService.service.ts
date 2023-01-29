import { Injectable } from "@angular/core";

declare const Xonomy: any;

@Injectable({
    providedIn:'root'
})
export class XonomyResenjeCreateService{
    constructor(){}

    public resenjeSpecification = {
        elements:{
            'resenje':{
                hasText:false,
                attributes: {
                    'id':{
                        isInvisible:true
                    }
                }
            },
                'datum_odluke_o_zahtevu':{
                    hasText:true,
                    attributes: {
                        'about':{
                            isInvisible:true
                        },
                        'property':{
                            isInvisible:true
                        },
                        'datatype':{
                            isInvisible:true
                        }
                    }
                },
                'da_li_je_prosao':{
                    hasText:false,
                        menu:[{
                            caption:'Šifra pod kojim je patent zaveden',
                            action:Xonomy.newElementChild,
                            actionParameter: 
                            ` <sifra></sifra>`,
                            hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
                                return jsElement.hasChildElement('sifra') || jsElement.hasChildElement('obrazlozenje');
                            }
                        },
                        {
                            caption:'Dodaj obrazloženje zašto je odbijeno',
                            action:Xonomy.newElementChild,
                            actionParameter:
                            ' <obrazlozenje></obrazlozenje>',
                            hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
                                return jsElement.hasChildElement('sifra') || jsElement.hasChildElement('obrazlozenje');
                            }
                            
                        }
                    ]
                },
                    'sifra':{
                        hasText:true,
                            asker:Xonomy.askString,
                            menu: [{
                                caption: 'Obriši šifru',
                                action: Xonomy.deleteElement
                            }]
                    },
                    'obrazlozenje':{
                        hasText:true,
                        asker:Xonomy.askString,
                        menu: [{
                            caption: 'Obriši obrazloženje',
                            action: Xonomy.deleteElement
                        }]
                    },
                'sluzbenik':{
                    hasText:false,
                    attributes: {
                        'about':{
                            isInvisible:true
                        }
                    }
                },
                    'ime':{
                        hasText:true,
                        attributes: {
                            'property':{
                                isInvisible:true
                            },
                            'datatype':{
                                isInvisible:true
                            }
                        }
                    },
                    'prezime':{
                        hasText:true,
                        attributes: {
                            'property':{
                                isInvisible:true
                            },
                            'datatype':{
                                isInvisible:true
                            }
                        }
                    },
                'referenca_na_zahtev':{
                    hasText:false
                }
        }
    }
}