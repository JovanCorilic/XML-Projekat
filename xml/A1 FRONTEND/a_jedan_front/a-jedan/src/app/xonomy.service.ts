import { Injectable } from '@angular/core';

declare const Xonomy: any;

@Injectable({
  providedIn: 'root'
})
export class XonomyService {

  constructor() { }

  public A1Specification = {
    elements: {
      AJedan: { hasText:false },

      Jedan: {
        mustBeBefore: ['Dva'],
        hasText: false,
      },

        Podnosilac: {
          mustBeBefore: ['Telefonski_Broj'],
          hasText: false,
        },

          Ime: {
            mustBeBefore: ['Prezime'],
            hasText: true,
          },

          Prezime: {
            mustBeBefore: ['Adresa'],
            hasText: true,
          },

          Adresa: {
            mustBeBefore: ['Drzavljanstvo'],
            hasText: false,
          },

            Grad: {
              mustBeBefore: ['Ulica'],
              hasText: true,
            },

            Ulica: {
              mustBeBefore: ['Broj'],
              hasText: true,
            },

            Broj: {
              hasText: true,
            },

          Drzavljanstvo: {
            hasText: true,
          },

        Telefonski_Broj: {
          mustBeBefore: ['email'],
          hasText: true,
        },

        email: {
          hasText: true,
        },

      Dva: {
        mustBeBefore: ['Tri'],
        hasText: false,
        menu:[{//////////////////// jedno od ova 2  
            caption:'Dodaj Pseudonim',//Pseudonim
            action:Xonomy.newElementChild,
            actionParameter: 
            '<Pseudonim>'+
            '</Pseudonim>',
            hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
                return jsElement.hasChildElement('Pseudonim') || jsElement.hasChildElement('Znak_Autora');
            }
          },
          {
            caption:'Dodaj Znak_Autora',//Znak_Autora
            action:Xonomy.newElementChild,
            actionParameter:
            '<Znak_Autora>'+
            '</Znak_Autora>',
            hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
                return jsElement.hasChildElement('Pseudonim') || jsElement.hasChildElement('Znak_Autora');
            }
            
          },//////////////////
        ],
      },

        Pseudonim: {
          hasText: true,
        },

        Znak_Autora: {
          hasText: true,
        },

      Tri: {
        mustBeBefore: ['Cetiri'],
        hasText: false,
        menu:[{ 
            caption:'Dodaj Punomocnika',//Punomocnik
            action:Xonomy.newElementChild,
            actionParameter: 
            '<Punomocnik>'+
              '<Ime></Ime>'+
              '<Prezime></Prezime>'+
              '<Adresa>'+
                  '<Grad></Grad>'+
                  '<Ulica></Ulica>'+
                  '<Broj></Broj>'+
              '</Adresa>'+
            '</Punomocnik>',
            hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
                return jsElement.hasChildElement('Punomocnik');
            }
          },
        ],
      },

        Punomocnik: {
          hasText: false,
        },

          //Ime

          //Prezime

          //Adresa

      Cetiri: {
        mustBeBefore: ['Pet'],
        hasText: false,
      },

        Naslov: {
          mustBeBefore: ['Alternativni_Naslov'],
          hasText: true,
        },

        Alternativni_Naslov: {
          hasText: true,
        },

      Pet: {
        mustBeBefore: ['Sest'],
        hasText: false,
      },

        Autorsko_Delo_Prerade: {
          hasText: false,
        },

          Podaci_O_Originalnom_Autorskom_Delu: {
            mustBeBefore: ['Ime_Autora'],
            hasText: true,
          },

          Ime_Autora: {
            hasText: true,
          },

      Sest: {
        mustBeBefore: ['Sedam'],
        hasText: false,
      },

        Podaci_O_Vrsti_Autorskog_Dela: {
          hasText: true,
        },

      Sedeam: {
        mustBeBefore: ['Osam'],
        hasText: false,
      },

        Podaci_O_Formi_Autorskog_Zapisa_Dela: {
          hasText: true,
        },

      Osam: {
        mustBeBefore: ['Devet'],
        hasText: false,
        menu:[{ 
          caption:'Dodaj Podnosioce',//Podnosioci
          action:Xonomy.newElementChild,
          actionParameter: 
          '<Podnosioci>'+
            '<Zivi_Podnosioci></Zivi_Podnosioci>'+
            '<Mrtvi_Podnosioci></Mrtvi_Podnosioci>'+
            '<Anonimni_Podnosioci></Anonimni_Podnosioci>'+
          '</Podnosioci>',
          hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
              return jsElement.hasChildElement('Podnosioci');
          }
        },
      ],
      },

        Podnosioci: {
          hasText: false,
        },

          Zivi_Podnosioci: {
            mustBeBefore: ['Mrtvi_Podnosioci'],
            hasText: false,
            menu:[{ 
              caption:'Dodaj Zivog Podnosioca',//Ziv_Podnosilac
              action:Xonomy.newElementChild,
              actionParameter: 
              '<Ziv_Podnosilac>'+
                '<Ime></Ime>'+
                '<Prezime></Prezime>'+
                '<Adresa>'+
                    '<Grad></Grad>'+
                    '<Ulica></Ulica>'+
                    '<Broj></Broj>'+
                '</Adresa>'+
                '<Drzavljanstvo></Drzavljanstvo>'+
              '</Ziv_Podnosilac>',
              },
            ],
          },

          Mrtvi_Podnosioci: {
            mustBeBefore: ['Anonimni_Podnosioci'],
            hasText: false,
            menu:[{ 
              caption:'Dodaj Mrtvog Podnosioca',//Mrtav_Podnosilac
              action:Xonomy.newElementChild,
              actionParameter: 
              '<Mrtav_Podnosilac>'+
                '<Ime></Ime>'+
                '<Prezime></Prezime>'+
                '<Godina_Smrti></Godina_Smrti>'+
              '</Mrtav_Podnosilac>',
              },
            ],
          },

            Godina_Smrti: {
              hasText: true,
            },

          Anonimni_Podnosioci: {
            hasText: false,
            menu:[{ 
              caption:'Dodaj Anonimnog Podnosioca',//Anoniman_Podnosilac
              action:Xonomy.newElementChild,
              actionParameter: 
              '<Anoniman_Podnosilac>'+
                '<Delo_Anonimnog_Autora></Delo_Anonimnog_Autora>'+
              '</Anoniman_Podnosilac>',
              },
            ],
          },

            Delo_Anonimnog_Autora: {
              hasText: true,
            },

      Devet: {
        mustBeBefore: ['Deset'],
        hasText: false,
      },

        Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu: {
          hasText: true,
        },

      Deset: {
        mustBeBefore: ['Jedanaest'],
        hasText: false,
        menu:[{//////////////////// jedno od ova 2  
            caption:'Dodaj Nacin_Koriscenja_Autorskog_Dela',//Nacin_Koriscenja_Autorskog_Dela
            action:Xonomy.newElementChild,
            actionParameter: 
            '<Nacin_Koriscenja_Autorskog_Dela>'+
            '</Nacin_Koriscenja_Autorskog_Dela>',
            hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
                return jsElement.hasChildElement('Nacin_Koriscenja_Autorskog_Dela') || jsElement.hasChildElement('Nameravani_Nacin_Koriscenja_Autorskog_Dela');
            }
          },
          {
            caption:'Dodaj Nameravani_Nacin_Koriscenja_Autorskog_Dela',//Nameravani_Nacin_Koriscenja_Autorskog_Dela
            action:Xonomy.newElementChild,
            actionParameter:
            '<Nameravani_Nacin_Koriscenja_Autorskog_Dela>'+
            '</Nameravani_Nacin_Koriscenja_Autorskog_Dela>',
            hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
                return jsElement.hasChildElement('Nacin_Koriscenja_Autorskog_Dela') || jsElement.hasChildElement('Nameravani_Nacin_Koriscenja_Autorskog_Dela');
            }
            
          },//////////////////
        ],
      },

        Nacin_Koriscenja_Autorskog_Dela: {
          hasText: true,
        },

        Nameravani_Nacin_Koriscenja_Autorskog_Dela: {
          hasText: true,
        },

      Jedanaest: {
        mustBeBefore: ['Dvanaest'],
        hasText: false,
      },

        Potpis: {
          hasText: true,
        },

      Dvanaest: {
        mustBeBefore: ['Opis_Autorskog_Dela'],
        hasText: false,
      },

        Prilozi_Uz_Zahtev: {
          hasText: true,
        },

      Opis_Autorskog_Dela: {
        mustBeBefore: ['Broj_Prijace'],
        hasText: true,
      },

      Broj_Prijace: {
        mustBeBefore: ['Datum_Podnosenja'],
        hasText: true,
      },

      Datum_Podnosenja: {
        hasText: true,
      },
    }
  }
}
