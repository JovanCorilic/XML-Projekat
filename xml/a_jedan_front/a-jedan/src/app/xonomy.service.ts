import { Injectable } from '@angular/core';

declare const Xonomy: any;

@Injectable({
  providedIn: 'root'
})
export class XonomyService {

  constructor() { }

  public A1Specification = {
    elements: {
      'A-1': { hasText:false,
        menu: [{
          caption: 'Dodaj Alternativni Naslov',
          action: Xonomy.newElementChild,
          actionParameter: '<alternativni_naslov></alternativni_naslov>',
          hideIf: function (jsElement :{hasChildElement: (arg0: string) => any}) {
            return jsElement.hasChildElement("alternativni_naslov")
          },
        },
        {
          caption:'Dodaj prilozi zahtev',
          action:Xonomy.newElementChild,
          actionParameter: 
          '<podneti_prilozi_zahtev>'+
            '<popunjava>'+
                '<ime>'+
                '</ime>'+
                '<prezime>'+
                '</prezime>'+
            '</popunjava>'+
            '<prilozi_prijave>'+
            '</prilozi_prijave>'+
            '<opis_autorskog_dela>'+
            '</opis_autorskog_dela>'+
            '<primer_autorskog_dela>'+
            '</primer_autorskog_dela>'+
            '<popunjava>'+
                '<ime>'+
                '</ime>'+
                '<prezime>'+
                '</prezime>'+
            '</popunjava>'+
            '<prilozi_prijave>'+
            '</prilozi_prijave>'+
            '<opis_autorskog_dela>'+
            '</opis_autorskog_dela>'+
            '<primer_autorskog_dela>'+
            '</primer_autorskog_dela>'+
          '</podneti_prilozi_zahtev>'
          
        },

        {
          caption: 'Dodaj Podatke o zasnivanju',
          action: Xonomy.newElementChild,
          actionParameter: 
          '<podaci_o_zasnivanju>'+
            '<podaci_o_naslovu></podaci_o_naslovu>'+
            '<podaci_o_autoru>'+
              '<ime></ime>'+
              '<prezime></prezime>'+
            '</podaci_o_autoru>'+
          '</podaci_o_zasnivanju>',
          hideIf: function (jsElement :{hasChildElement: (arg0: string) => any}) {
            return jsElement.hasChildElement("podaci_o_zasnivanju")
          },
        },

        {//////////////////// jedno od ova 2  
          caption:'Dodaj firmu kao podnosioca',//podnosilac_firma
          action:Xonomy.newElementChild,
          actionParameter: 
          '<podnosilac_firma>'+
            '<poslovno_ime>'+
            '</poslovno_ime>'+
            '<sediste_nosioca_autorskog>'+
            '</sediste_nosioca_autorskog>'+
          '</podnosilac_firma>',
          hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
              return jsElement.hasChildElement('podnosilac_firma') || jsElement.hasChildElement('podnosilac_lice');
          }
        },
        {
          caption:'Dodaj lice kao podnosioca',//podnosilac_lice
          action:Xonomy.newElementChild,
          actionParameter:
          '<podnosilac_lice>'+
            '<ime>'+
            '</ime>'+
            '<prezime>'+
            '</prezime>'+
            '<adresa>'+
            '</adresa>'+
            '<drzavljanstvo>'+
            '</drzavljanstvo>'+
          '</podnosilac_lice>',
          hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
              return jsElement.hasChildElement('podnosilac_firma') || jsElement.hasChildElement('podnosilac_lice');
          }
          
        },//////////////////

        {//////////////////// jedno od ova 2  
          caption:'Dodaj znak autora',//znak_autora
          action:Xonomy.newElementChild,
          actionParameter: 
          '<znak_autora></znak_autora>',
          hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
              return jsElement.hasChildElement('znak_autora') || jsElement.hasChildElement('pseudonim');
          }
        },
        {
          caption:'Dodaj pseudonim',//pseudonim
          action:Xonomy.newElementChild,
          actionParameter:
          '<pseudonim></pseudonim>',
          hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
              return jsElement.hasChildElement('znak_autora') || jsElement.hasChildElement('pseudonim');
          }
          
        },//////////////////

        {//////////////////// jedno od ova 2  
          caption:'Dodaj nacin koriscenja autorskog dela',//nacin_koriscenja_autorskog_dela
          action:Xonomy.newElementChild,
          actionParameter: 
          '<nacin_koriscenja_autorskog_dela></nacin_koriscenja_autorskog_dela>',
          hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
              return jsElement.hasChildElement('nacin_koriscenja_autorskog_dela') || jsElement.hasChildElement('nameravani_nacin_korišćenja_autorskog_dela');
          }
        },
        {
          caption:'Dodaj nameravani nacin korišćenja autorskog dela',//nameravani_nacin_korišćenja_autorskog_dela
          action:Xonomy.newElementChild,
          actionParameter:
          '<nameravani_nacin_korišćenja_autorskog_dela></nameravani_nacin_korišćenja_autorskog_dela>',
          hideIf: function(jsElement: {hasChildElement: (arg0: string) => any}){
              return jsElement.hasChildElement('nacin_koriscenja_autorskog_dela') || jsElement.hasChildElement('nameravani_nacin_korišćenja_autorskog_dela');
          }
          
        }//////////////////
        ],
      },
      podneti_prilozi_zahtev: {
        mustBeBefore: ['broj_prijave'],//#########TODO:#########################################
        hasText: false,
        menu:[{
          caption:'Obrisi prilozi zahtev',
          action:Xonomy.deleteElement
        },
        ],
      },
      
      podnosioci: {
        mustBeBefore: [],//#########TODO:#########################################
        hasText: false,
        menu: [{
          caption: 'Dodaj podnosioca',
          action: Xonomy.newElementChild,
          actionParameter: 
          '<podnosilac>'+
            '<ziv>'+
                '<prezime>'+
                '</prezime>'+
                '<ime>'+
                '</ime>'+
                '<adresa>'+
                    '<grad>'+
                    '</grad>'+
                    '<naziv_ulice>'+
                    '</naziv_ulice>'+
                    '<broj_ulice>'+
                    '</broj_ulice>'+
                '</adresa>'+
                '<drzavljanstvo>'+
                '</drzavljanstvo>'+
            '</ziv>'+
          '</podnosilac>'
        },
        {
          caption: 'Dodaj mrtvog podnosioca',
          action: Xonomy.newElementChild,
          actionParameter: 
          '<podnosilac>'+
            '<mrtav>'+
                '<prezime>'+
                '</prezime>'+
                '<ime>'+
                '</ime>'+
                '<godina_smrti>'+
                '</godina_smrti>'+
            '</mrtav>'+
          '</podnosilac>'
        },
        {
          caption: 'Dodaj anonimnog podnosioca',
          action: Xonomy.newElementChild,
          actionParameter: 
          '<anoniman>'+
            '<delo_delo_anonimnog_autora>'+
            '</delo_delo_anonimnog_autora>'+
          '</anoniman>'
        },
        ]
      },
      autor: {
        mustBeBefore: ['zavod_za_intelektualnu_svoinu'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      ime: {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      prezime: {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      adresa: {
        mustBeBefore: ['obrazac'],
      },
      grad: {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      naziv_ulice: {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      broj_ulice: {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      zavod_za_intelektualnu_svoinu: {
        mustBeBefore: ['adresa'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      obrazac: {
        mustBeBefore: ['naslov'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      naslov: {
        mustBeBefore: ['telefon','podaci_o_zasnivanju','vrsti_autorskog_dela'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      podnosilac_lice: {
        mustBeBefore: ['telefon'],
      },
      podnosilac_firma: {
        mustBeBefore: ['telefon'],
      },
      telefon: {
        mustBeBefore: ['email'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      email: {
        mustBeBefore: ['znak_autora','pseudonim'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      alternativni_naslov: {
        mustBeBefore: ['podaci_o_zasnivanju','vrsti_autorskog_dela'],
      },
      vrsti_autorskog_dela: {
        mustBeBefore: ['forma_zapisa_autorskog_dela'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      forma_zapisa_autorskog_dela: {
        mustBeBefore: ['podnosioci'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      da_li_je_delo_stvoreno_u_radnom_odnosu: {
        mustBeBefore: ['nacin_koriscenja_autorskog_dela','nameravani_nacin_korišćenja_autorskog_dela','nosilac_prijave'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      nacin_koriscenja_autorskog_dela: {
        mustBeBefore: ['nosilac_prijave'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      nameravani_nacin_korišćenja_autorskog_dela: {
        mustBeBefore: ['nosilac_prijave'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      nosilac_prijave: {
        mustBeBefore: ['podneti_prilozi_zahtev'],
      },
      broj_prijave: {
        mustBeBefore: ['datum_podnosenja'],
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
      datum_podnosenja: {
        hasText: true,
        oneliner: true,
        asker: Xonomy.askString,
      },
    }
  }
}
