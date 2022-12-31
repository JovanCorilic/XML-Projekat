import { Injectable } from "@angular/core";

declare const Xonomy: any;

@Injectable({
    providedIn:'root'
})

export class XonomyPatentCreateService{
    constructor(){}
    
    public PatentSpecification = {
        elements:{
            'P-1':{
                hasText:false,
            },
                'popunjava_zavod':{
                    hasText:false
                },
                'broj_prijave':{
                    hasText:false
                },
                'datum_prijema':{
                    hasText:false
                },
                'priznati_datum_podnosenja':{
                    hasText:false
                },
                'pecat_i_potpis':{
                    hasText:true,
                    isReadOnly:true
                },
                'drzava':{
                    hasText:true,
                    isReadOnly:true
                },
                'ustanova':{
                    hasText:true,
                    isReadOnly:true
                },
                    'adresa_ustanove':{
                        isReadOnly:true,
                        hasText:false
                    },
                    'naziv_ulice_ustanove':{
                        hasText:true
                    },
                    'broj_ulice_ustanove':{
                        hasText:true
                    },
                    'grad_ustanove':{
                        hasText:true
                    },
                    'postanski_broj_ustanove':{
                        hasText:true
                    },
            'naslov':{
                hasText:true,
                isReadOnly:true
            },
            'naziv_pronalaska':{
                hasText:false
            },
                'srpski_naziv':{
                    hasText:true,
                    oneliner:true
                },
                'engleski_naziv':{
                    hasText:true,
                    oneliner:true
                },
            'podnosilac_prijave':{
                hasText:false
            },
                'licne_informacije':{
                    hasText:false
                },
                    'naziv':{
                        hasText:false,
                        menu:[{
                            caption:'Dodaj naziv osobe',
                            action:Xonomy.newElementChild,
                            actionParameter: 
                            ' <osoba>'+
                                ' <ime> </ime>'+
                                ' <prezime> </prezime>'+
                            ' </osoba> ',
                            hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
                                return jsElement.hasChildElement('ososba');
                            }
                        },
                        {
                            caption:'Dodaj poslovno ime',
                            action:Xonomy.newElementChild,
                            actionParameter:
                            ' <firma>'+
                            ' <poslovno_ime> </poslovno_ime>'+
                            ' </firma> ',
                            hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
                                return jsElement.hasChildElement('firma');
                            }
                        }
                    ]
                    },
                        'osoba':{
                            hasText:false,
                            asker:Xonomy.askString,
                            menu: [{
                                caption: 'Obriši osoba',
                                action: Xonomy.deleteElement
                            }]
                        },
                            'ime':{
                                hasText:true,
                                oneliner:true
                            },
                            'prezime':{
                                hasText:true,
                                oneliner:true
                            },
                        'firma':{
                            hasText:false,
                            asker:Xonomy.askString,
                            menu: [{
                                caption: 'Obriši poslovno ime',
                                action: Xonomy.deleteElement
                            }]
                        },
                            'poslovno_ime':{
                                hasText:true,
                                oneliner:true
                            },
                    'prebivaliste':{
                        hasText:false
                    },
                        'naziv_ulice':{
                            hasText:true
                        },
                        'broj_ulice':{
                            hasText:true
                        },
                        'postanski_broj':{
                            hasText:true
                        },
                        'naziv_grada':{
                            hasText:true
                        },
                        'naziv_drzave':{
                            hasText:true
                        },
                    'kontakt':{
                        hasText:false
                    },
                        'broj_telefona':{
                            hasText:true
                        },
                        'broj_faksa':{
                            hasText:true
                        },
                        'e-posta':{
                            hasText:true
                        },
                'drzavljanstvo':{
                    hasText:true
                },
                'je_pronalazac':{
                    asker:Xonomy.askPicklist,
                    askerParameter:["true","false"]
                }    
        }
    }
}