import { Patent } from './../../MODEL/Patent';
import { Router } from '@angular/router';
import { XonomyPatentCreateService } from '../../SERVICE/xonomyPatentCreate.service';
import { Component } from '@angular/core';
import { PatentService } from 'src/app/SERVICE/patent.service';

declare const Xonomy: any;
@Component({
  selector: 'app-patent-create',
  templateUrl: './patent-create.component.html',
  styleUrls: ['./patent-create.component.css']
})
export class PatentCreateComponent {
  constructor(private xonomyPatentCreateService: XonomyPatentCreateService,
    private router: Router,
    private patentService: PatentService){}

  ngAfterViewInit(): void{
    let element = document.getElementById("editor");

    let xmlLicneInformacije = 
    ' <licne_informacije>'+
        ' <naziv></naziv>'+
        ' <prebivaliste>'+
            ' <naziv_ulice> </naziv_ulice>'+
            ' <broj_ulice> </broj_ulice>'+
            ' <postanski_broj> </postanski_broj>'+
            ' <naziv_grada> </naziv_grada>'+
            ' <naziv_drzave> </naziv_drzave>'+
        ' </prebivaliste>'+
        ' <kontakt>'+
            ' <broj_telefona> </broj_telefona>'+
            ' <broj_faksa> </broj_faksa>'+
            ' <e-posta> </e-posta>'+
        ' </kontakt>'+
    ' </licne_informacije>'
    

    let xml = 
    ' <P-1 xmlns="http://www.ftn.uns.rs/P-1" id=""'+
      ' xmlns:pred="http://www.ftn.uns.ac.rs/rdf/examples/predicate/">'+
      ' <popunjava_zavod about="http://www.ftn.uns.ac.rs/rdf/patent"> '+
        ' <broj_prijave property="pred:brojPrijave" datatype="xs:string"> </broj_prijave>'+
        ' <datum_prijema> </datum_prijema>'+
        ' <priznati_datum_podnosenja> </priznati_datum_podnosenja>'+
        ' <pecat_i_potpis>Nevazno</pecat_i_potpis>'+
        ' <drzava>Republika Srbija</drzava>'+
        ' <ustanova>Zavod za intelektualnu svojinu</ustanova>'+
        ' <adresa_ustanove>'+
            ' <naziv_ulice_ustanove>Kneginje LJubice</naziv_ulice_ustanove>'+ 
            ' <broj_ulice_ustanove>5</broj_ulice_ustanove>'+
            ' <grad_ustanove>Beograd</grad_ustanove>'+
            ' <postanski_broj_ustanove>11000</postanski_broj_ustanove>'+
        ' </adresa_ustanove>'+
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
    
    let specification = this.xonomyPatentCreateService.PatentSpecification;
    Xonomy.setMode("laic");
    Xonomy.render(xml,element,specification);
    Xonomy.refresh();
    
  }

  send(){
    let text = Xonomy.harvest();
    
    text = '<?xml version="1.0" encoding="UTF-8"?>'+
    ' <?xml-stylesheet type="text/xsl" href="src/main/resources/xslt/P-1.xsl"?> '+ text;
    
    //console.log(text);
    this.patentService.sendXml(text).subscribe(
      res=>{this.router.navigate(['']);}
    )
  }

  back(){
    this.router.navigate(['']);
  }
}
