import { Patent } from './../../MODEL/Patent';
import { Router } from '@angular/router';
import { XonomyService } from './../../SERVICE/xonomyPatent.service';
import { Component } from '@angular/core';
import { PatentService } from 'src/app/SERVICE/patent.service';

declare const Xonomy: any;
@Component({
  selector: 'app-patent-create',
  templateUrl: './patent-create.component.html',
  styleUrls: ['./patent-create.component.css']
})
export class PatentCreateComponent {
  constructor(private xonomyService: XonomyService,
    private router: Router,
    private patentService: PatentService){}

  ngAfterViewInit(){
    let element = document.getElementById("editor");

    let xmlLicneInformacije = 
    ' <licne_informacije>'+
        ' <naziv></naziv>'+
        ' <prebivaliste>'+
            ' <ulica> </ulica>'+
            ' <broj_ulice> </broj_ulice>'+
            ' <postanski_broj> </postanski_broj>'+
            ' <grad> </grad>'+
            ' <drzava> </drzava>'+
        ' </prebivaliste>'+
        ' <kontakt>'+
            ' <broj_telefona> </broj_telefona>'+
            ' <broj_faksa> </broj_faksa>'+
            ' <e-posta> </e-posta>'+
        ' </kontakt>'+
    ' </licne_informacije>'
    

    let xml = 
    '<P-1 xmlns="http://www.ftn.uns.rs/P-1"'+
      ' xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"'+
      ' xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/">'+
      ' <popunjava_zavod about="http://www.ftn.uns.ac.rs/rdf/patent"> '+
        ' <broj_prijave property="pred:brojPrijave" datatype="xs:int"> </broj_prijave>'+
        ' <datum_prijema> </datum_prijema>'+
        ' <priznati_datum_podnosenja> </priznati_datum_podnosenja>'+
        ' <pecat_i_potpis>Nevazno</pecat_i_potpis>'+
        ' <drzava>Republika Srbija</drzava>'+
        ' <ustanova>Zavod za intelektualnu svojinu</ustanova>'+
        ' <adresa>'+
            ' <naziv_ulice>Kneginje LJubice</naziv_ulice>'+ 
            ' <broj_ulice>5</broj_ulice>'+
            ' <grad>Beograd</grad>'+
            ' <postanski_broj>11000</postanski_broj>'+
        ' </adresa>'+
      ' </popunjava_zavod>'+
      ' <naslov>ZAHTEV ZA PRIZNANJE PATENTA</naslov>'+
      ' <naziv_pronalaska about="http://www.ftn.uns.ac.rs/rdf/patent">'+
        ' <srpski_naziv property="pred:nazivPatentaSrpski" datatype="xs:string"> </srpski_naziv>'+
        ' <engleski_naziv property="pred:nazivPatentaEngleski" datatype="xs:string"></engleski_naziv>'+
      ' </naziv_pronalaska>'+
      ' <podnosilac_prijave>'+
      xmlLicneInformacije+
      ' <drzavljanstvo> </drzavljanstvo>'+
      ' <je_pronalazac> </je_pronalazac>'+
      ' </podnosilac_prijave> '+
      ' <pronalazac>'+
      ' <da_li_pronalazac_zeli_da_bude_naveden> </da_li_pronalazac_zeli_da_bude_naveden>'+
      xmlLicneInformacije+
      ' </pronalazac>'+
      ' <punomocnik>'+
      ' <da_li_je_punomocnik_za_zastupanje> </da_li_je_punomocnik_za_zastupanje>'+
      ' <da_li_je_punomocnik_za_prijem_pismena> </da_li_je_punomocnik_za_prijem_pismena>'+
      ' <da_li_je_zajednicki_predstavnik> </da_li_je_zajednicki_predstavnik>'+
      xmlLicneInformacije+
      ' </punomocnik>'+
      ' <dostavljanje>'+
          ' <adresa>'+
              ' <naziv_ulice> </naziv_ulice>'+
              ' <broj_ulice> </broj_ulice>'+
              ' <grad> </grad>'+
              ' <postanski_broj> </postanski_broj>'+
          ' </adresa>'+
          ' <nacin>'+
              ' <dostavljanje_pismena_iskljucivo_elektronskim_putem> </dostavljanje_pismena_iskljucivo_elektronskim_putem>'+
              ' <dostavljanje_pismena_u_papirnoj_formi> </dostavljanje_pismena_u_papirnoj_formi>'+
          ' </nacin>'+
      ' </dostavljanje>'+
      ' <tip_prijave>'+
          ' <da_li_je_dopunska_prijava> </da_li_je_dopunska_prijava>'+
          ' <da_li_je_izdvojena_prijava> </da_li_je_izdvojena_prijava>'+
          ' <broj_prvobitne_prijave> </broj_prvobitne_prijave>'+
          ' <datum_podnosenja_prvobitne_prijave> </datum_podnosenja_prvobitne_prijave>'+
      ' </tip_prijave>'+
      ' <zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava> </zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava>'+
    ' </P-1>'
    
  }

  send(){
    let text = Xonomy.harvest();
    const patent = new Patent("");
    patent.text=text;
    this.patentService.sendXml(patent).subscribe(
      res=>{this.router.navigate(['']);}
    )
  }

  back(){
    this.router.navigate(['']);
  }
}
