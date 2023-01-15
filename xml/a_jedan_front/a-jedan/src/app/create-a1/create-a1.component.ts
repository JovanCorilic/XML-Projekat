import { Component, OnInit } from '@angular/core';
import { XonomyService } from '../xonomy.service';

declare const Xonomy: any
@Component({
  selector: 'app-create-a1',
  templateUrl: './create-a1.component.html',
  styleUrls: ['./create-a1.component.css']
})
export class CreateA1Component implements OnInit {

  constructor(private xonomyService: XonomyService) { }

  ngOnInit() {

  }
  ngAfterViewInit() {
    let element = document.getElementById("editor");
    let specification = this.xonomyService.A1Specification;
    let xmlString = 
    '<A-1 xmlns="https://www.D_A_B_F#_G_D_G_A.com">'+
    '<zavod_za_intelektualnu_svoinu>'+
    '</zavod_za_intelektualnu_svoinu>'+
    '<adresa>'+
        '<grad>'+
        '</grad>'+
        '<naziv_ulice>'+
        '</naziv_ulice>'+
        '<broj_ulice>'+
        '</broj_ulice>'+
    '</adresa>'+
    '<obrazac>'+
    '</obrazac>'+
    '<naslov>'+
    '</naslov>'+
    /*'<podnosilac_firma>'+  ili podnosilac firma ili podnosilac lice
        '<poslovno_ime>'+
        '</poslovno_ime>'+
        '<sediste_nosioca_autorskog>'+
        '</sediste_nosioca_autorskog>'+
    '</podnosilac_firma>'+*/
    '<telefon>'+
    '</telefon>'+
    '<email>'+
    '</email>'+
    /*'<znak_autora>'+   ili znak ili oseudonim
    '</znak_autora>'+*/
    '<autor>'+
        '<ime>'+
        '</ime>'+
        '<prezime>'+
        '</prezime>'+
        '<adresa>'+
            '<grad>'+
            '</grad>'+
            '<naziv_ulice>'+
            '</naziv_ulice>'+
            '<broj_ulice>'+
            '</broj_ulice>'+
        '</adresa>'+
    '</autor>'+
    '<naslov>'+
    '</naslov>'+
    /* moze da ima i dodatni naslov (alt)*/
    /* moze da ima i podatke o zasnicanju */
    '<vrsti_autorskog_dela>'+
    '</vrsti_autorskog_dela>'+
    '<forma_zapisa_autorskog_dela>'+
    '</forma_zapisa_autorskog_dela>'+
    '<podnosioci>'+
        /*'<podnosilac>'+ mora bar jedan od 3 ponudjena
            '<anoniman>'+
                '<delo_delo_anonimnog_autora>'+
                '</delo_delo_anonimnog_autora>'+
            '</anoniman>'+
        '</podnosilac>'+
        '<podnosilac>'+
            '<anoniman>'+
                '<delo_delo_anonimnog_autora>'+
                '</delo_delo_anonimnog_autora>'+
            '</anoniman>'+
        '</podnosilac>'+*/
    '</podnosioci>'+
    '<da_li_je_delo_stvoreno_u_radnom_odnosu>'+
    '</da_li_je_delo_stvoreno_u_radnom_odnosu>'+
    /*'<nacin_koriscenja_autorskog_dela>'+ jedno od 2
    '</nacin_koriscenja_autorskog_dela>'+*/
    '<nosilac_prijave>'+
        '<podnosilac_prijave>'+
        '</podnosilac_prijave>'+
    '</nosilac_prijave>'+
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
        /*'<popunjava>'+ moze vise da ih ima
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
        '</primer_autorskog_dela>'+*/
    '</podneti_prilozi_zahtev>'+
    '<broj_prijave>'+
    '</broj_prijave>'+
    '<datum_podnosenja>'+
    '</datum_podnosenja>'+
    '</A-1>';
    Xonomy.render(xmlString, element, specification);
  }


}
