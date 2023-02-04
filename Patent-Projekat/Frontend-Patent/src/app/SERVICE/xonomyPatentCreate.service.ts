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
                attributes: {
                    'id':{
                        isInvisible:true
                    }
                }
            },
                'popunjava_zavod':{
                    hasText:false,
                    isReadOnly:true,
                    attributes: {
                        'about':{
                            isInvisible:true
                        }
                    }
                },
                    'broj_prijave':{
                        hasText:false,
                        isReadOnly:true,
                        attributes: {
                            'property':{
                                isInvisible:true
                            },
                            'datatype':{
                                isInvisible:true
                            }
                        }
                    },
                    'datum_prijema':{
                        hasText:false,
                        isReadOnly:true
                    },
                    'priznati_datum_podnosenja':{
                        hasText:false,
                        isReadOnly:true,
                        attributes: {
                            'property':{
                                isInvisible:true
                            },
                            'datatype':{
                                isInvisible:true
                            }
                        }
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
                hasText:false,
                attributes: {
                    'about':{
                        isInvisible:true
                    }
                }
            },
                'srpski_naziv':{
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
                'engleski_naziv':{
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
                                return jsElement.hasChildElement('osoba') || jsElement.hasChildElement('firma');
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
                                return jsElement.hasChildElement('osoba') || jsElement.hasChildElement('firma');
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
                                hasText:true
                            },
                            'prezime':{
                                hasText:true
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
                                hasText:true
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
                    hasText:true,
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
            'pronalazac':{
                hasText:false
            },
                'da_li_pronalazac_zeli_da_bude_naveden':{
                    hasText:true,
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
            'punomocnik':{
                hasText:false
            },
                'da_li_je_punomocnik_za_zastupanje':{
                    hasText:true,
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
                'da_li_je_punomocnik_za_prijem_pismena':{
                    hasText:true,
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
                'da_li_je_zajednicki_predstavnik':{
                    hasText:true,
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
                        hasText:true,
                        asker:Xonomy.askPicklist,
                        askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                    },
                    'dostavljanje_pismena_u_papirnoj_formi':{
                        hasText:true,
                        asker:Xonomy.askPicklist,
                        askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                    },
            'tip_prijave':{
                hasText:false
            },
                'da_li_je_dopunska_prijava':{
                    hasText:true,
                    asker:Xonomy.askPicklist,
                    askerParameter:[{value: "true", caption: "Da"},{value: "false", caption: "Ne"}]
                },
                'da_li_je_izdvojena_prijava':{
                    hasText:true,
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
                        hasText:true
                    },
                    'broj_ranije_prijave':{
                        hasText:true
                    },
                    'dvoslovna_oznaka_drzave_ili_organizacije':{
                        hasText:true
                    }
        }
    }
}