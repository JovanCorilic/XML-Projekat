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
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
            'pronalazac':{
                hasText:false
            },
            'punomocnik':{
                hasText:false
            },
                'da_li_je_punomocnik_za_zastupanje':{
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
                'da_li_je_punomocnik_za_prijem_pismena':{
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
                'da_li_je_zajednicki_predstavnik':{
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
            'dostavljanje':{
                hasText:false
            },
                'adresa':{
                    hasText:false
                },
                    'grad':{
                        hasText:true
                    },
                'nacin':{
                    hasText:false
                },
                    'dostavljanje_pismena_iskljucivo_elektronskim_putem':{
                        asker:Xonomy.askPicklist,
                        askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                    },
                    'dostavljanje_pismena_u_papirnoj_formi':{
                        asker:Xonomy.askPicklist,
                        askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                    },
            'tip_prijave':{
                hasText:false
            },
                'da_li_je_dopunska_prijava':{
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
                'da_li_je_izdvojena_prijava':{
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
                'broj_prvobitne_prijave':{
                    hasText:true
                },
                'datum_podnosenja_prvobitne_prijave':{
                    hasText:true
                },
            'zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava':{
                hasText:false,
                menu:[{
                    caption:'Dodaj ranije prijave',
                    action:Xonomy.newElementChild,
                    actionParameter: 
                    ' <ranija_prijava>'+
                        ' <datum_podnosenja_ranije_prijave> </datum_podnosenja_ranije_prijave>'+
                        ' <broj_ranije_prijave> </broj_ranije_prijave>'+
                        ' <dvoslovna_oznaka_drzave_ili_organizacije> </dvoslovna_oznaka_drzave_ili_organizacije>'+
                    ' </ranija_prijava> ',
                }]
            },
                'ranija_prijava':{
                    hasText:false
                },
                    'datum_podnosenja_ranije_prijave':{
                        hasText:false
                    },
                    'broj_ranije_prijave':{
                        hasText:false
                    },
                    'dvoslovna_oznaka_drzave_ili_organizacije':{
                        hasText:false
                    }
        }
    }
}