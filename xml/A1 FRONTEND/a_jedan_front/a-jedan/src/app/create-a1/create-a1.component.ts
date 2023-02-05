import { Component, OnInit } from '@angular/core';
import { Entity } from 'src/model/Entity';
import { AjedanService } from '../ajedan.service';
import { XonomyService } from '../xonomy.service';
import { HttpClient } from '@angular/common/http'
import { Router } from '@angular/router';


declare const Xonomy: any
@Component({
  selector: 'app-create-a1',
  templateUrl: './create-a1.component.html',
  styleUrls: ['./create-a1.component.css']
})
export class CreateA1Component implements OnInit {

  constructor(private xonomyService: XonomyService, private AJedanService:AjedanService, private http: HttpClient, private router: Router) { }
  private path = "http://localhost:8080/novi-dokument"
  ngOnInit() {
    let myContainer = document.getElementById('datum') as HTMLInputElement
    myContainer.setAttribute('value', this.datum());

    var x = Date.now();
    let d:string = x+'';
    let broj_prijave = document.getElementById('broj_prijave') as HTMLInputElement
    broj_prijave.setAttribute('value', d);
  }
  ngAfterViewInit() {
    let element = document.getElementById("editor");
    let specification = this.xonomyService.A1Specification;
    let xmlString = 
    //'<AJedan xmlns="https://www.D_A_B_F#_G_D_G_A.com">'+
    '<AJedan xmlns:x=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:pred=\"https://1564.com/predicate\" xmlns=\'https://www.D_A_B_F#_G_D_G_A.com\'>'+
        '<Jedan>'+
            '<Podnosilac>'+
                '<Ime></Ime>'+
                '<Prezime></Prezime>'+
                '<Adresa>'+
                    '<Grad></Grad>'+
                    '<Ulica></Ulica>'+
                    '<Broj></Broj>'+
                '</Adresa>'+
                '<Drzavljanstvo></Drzavljanstvo>'+
            '</Podnosilac>'+
            '<Telefonski_Broj></Telefonski_Broj>'+
            '<email></email>'+
        '</Jedan>'+

        '<Dva>'+
            //moze da ima Pseudonim ili Znak_Autora
        '</Dva>'+

        '<Tri>'+
            //moze da ima 0 ili vise Punomocnika
        '</Tri>'+

        '<Cetiri>'+
            '<x:Naslov xmlns:x="https://1564.com" property="pred:Naslov"></x:Naslov>'+
            '<Alternativni_Naslov></Alternativni_Naslov>'+
        '</Cetiri>'+

        '<Pet>'+
            '<Autorsko_Delo_Prerade>'+
                '<Podaci_O_Originalnom_Autorskom_Delu></Podaci_O_Originalnom_Autorskom_Delu>'+
                '<Ime_Autora></Ime_Autora>'+
            '</Autorsko_Delo_Prerade>'+
        '</Pet>'+

        '<Sest>'+
            '<x:Podaci_O_Vrsti_Autorskog_Dela xmlns:x="https://1564.com" property="pred:Podaci_O_Vrsti_Autorskog_Dela"></x:Podaci_O_Vrsti_Autorskog_Dela>'+
        '</Sest>'+

        '<Sedam>'+
            '<Podaci_O_Formi_Autorskog_Zapisa_Dela></Podaci_O_Formi_Autorskog_Zapisa_Dela>'+
        '</Sedam>'+

        '<Osam>'+
            //moze da ima 0 ili vise Podnosioca
        '</Osam>'+

        '<Devet>'+
            '<Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu></Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu>'+
        '</Devet>'+

        '<Deset>'+
            //moze da ima Nacin_Koriscenja_Autorskog_Dela ili Nameravani_Nacin_Koriscenja_Autorskog_Dela
        '</Deset>'+

        '<Jedanaest>'+
            '<x:Potpis xmlns:x="https://1564.com" property="pred:Potpis"></x:Potpis>'+
        '</Jedanaest>'+

        '<Dvanaest>'+
            '<Prilozi_Uz_Zahtev></Prilozi_Uz_Zahtev>'+
        '</Dvanaest>'+

        '<Opis_Autorskog_Dela></Opis_Autorskog_Dela>'+
        '<x:Broj_Prijace xmlns:x="https://1564.com" property="pred:Broj_Prijace"></x:Broj_Prijace>'+
        '<x:Datum_Podnosenja xmlns:x="https://1564.com" property="pred:Datum_Podnosenja"></x:Datum_Podnosenja>'+

    '</AJedan>';
    Xonomy.render(xmlString, element, specification);
  }

  posalji(){
    let text = Xonomy.harvest();
    const entity = new Entity();
    entity.text = text;
    console.log(entity);
    this.AJedanService.sendXml(entity);
  }

  Postoji(idd:string){
    if(document.getElementById(idd))
        return true;
    return false;
  }

  Postavi(idd:string){
    if(document.getElementById(idd))
        return (<HTMLInputElement>document.getElementById(idd)).value//document.getElementById(idd)?.getAttribute('value');
    return " ";
  }

  Osam(){
    if( !this.Postoji('ime8_1z') && !this.Postoji('ime8_1m') && !this.Postoji('delo8_1a') ){
        return '';
    }
    let odg = '<Podnosioci>';

    if(this.Postoji("ime8_1z")){
        odg += '<Zivi_Podnosioci>'
        for (let indeksator = 1 ; indeksator < 100 ; ++indeksator){
            if(this.Postoji("ime8_" + indeksator + "z")){
                odg += '<Ziv_Podnosilac>'+
                    '<Ime xml:space=\'preserve\'>' + this.Postavi("ime8_" + indeksator + "z") + '</Ime>'+
                    '<Prezime xml:space=\'preserve\'>' + this.Postavi("prezime8_" + indeksator + "z") + '</Prezime>'+
                    '<Adresa>'+
                        '<Grad xml:space=\'preserve\'>' + this.Postavi("grad8_" + indeksator + "z") + '</Grad>'+
                        '<Ulica xml:space=\'preserve\'>' + this.Postavi("ulica8_" + indeksator + "z") + '</Ulica>'+
                        '<Broj xml:space=\'preserve\'>' + this.Postavi("broj8_" + indeksator + "z") + '</Broj>'+
                    '</Adresa>'+
                    '<Drzavljanstvo xml:space=\'preserve\'>'  + this.Postavi("drzavljanstvo8_" + indeksator + "z") + '</Drzavljanstvo>'+
                '</Ziv_Podnosilac>';
            }
        }
        odg += '</Zivi_Podnosioci>'
    }

    if(this.Postoji("ime8_1m")){
        odg += '<Mrtvi_Podnosioci>'
        for (let indeksator = 1 ; indeksator < 100 ; ++indeksator){
            if(this.Postoji("ime8_" + indeksator + "z")){
                odg += '<Mrtav_Podnosilac>'+
                    '<Ime xml:space=\'preserve\'>' + this.Postavi("ime8_" + indeksator + "m") + '</Ime>'+
                    '<Prezime xml:space=\'preserve\'>' + this.Postavi("prezime8_" + indeksator + "m") + '</Prezime>'+
                    '<Godina_Smrti xml:space=\'preserve\'>' + this.Postavi("umro8_" + indeksator + "m") + '</Godina_Smrti>'+
                '</Mrtav_Podnosilac>';
            }
        }
        odg += '</Mrtvi_Podnosioci>'
    }

    if(this.Postoji("delo8_1a")){
        odg += '<Anonimni_Podnosioci>'
        for (let indeksator = 1 ; indeksator < 100 ; ++indeksator){
            if(this.Postoji("delo8_" + indeksator + "a")){
                odg += '<Anoniman_Podnosilac>'+
                    '<Delo_Anonimnog_Autora xml:space=\'preserve\'>' + this.Postavi("delo8_" + indeksator + "a") + '</Delo_Anonimnog_Autora>'+
                '</Anoniman_Podnosilac>';
            }
        }
        odg += '</Anonimni_Podnosioci>'
    }

    return odg + '</Podnosioci>'
  }

  posalji_popunjen(){
    //let text = '<AJedan xmlns=\'https://www.D_A_B_F#_G_D_G_A.com\'><Jedan><Podnosilac><Ime>Marko</Ime><Prezime>Savic</Prezime><Adresa><Grad>Srbobran</Grad><Ulica>Topolska</Ulica><Broj>18</Broj></Adresa><Drzavljanstvo>Juznoafricka Republika</Drzavljanstvo></Podnosilac></Jedan><Dva><Znak_Autora>[ZNAK]</Znak_Autora></Dva><Tri><Punomocnik><Ime>Sava</Ime><Prezime>Babic</Prezime><Adresa><Grad>Ruski Krstur</Grad><Ulica>Ive Lole Ribara</Ulica><Broj>11</Broj></Adresa></Punomocnik></Tri><Cetiri><x:Naslov property=\'pred:Naslov\'>Patent 213441</x:Naslov><Alternativni_Naslov>Nas patetnt</Alternativni_Naslov></Cetiri><Pet><Autorsko_Delo_Prerade><Podaci_O_Originalnom_Autorskom_Delu>uzeto sa git huba</Podaci_O_Originalnom_Autorskom_Delu><Ime_Autora>Korisnik xXx_[iPr0]_HE4D5H00T_K1NG_BL4DEM45TER_420_xXx na git hubu</Ime_Autora></Autorsko_Delo_Prerade></Pet><Sest><x:Podaci_O_Vrsti_Autorskog_Dela property=\'pred:Podaci_O_Vrsti_Autorskog_Dela\'>Nacrt</x:Podaci_O_Vrsti_Autorskog_Dela></Sest><Sedam><Podaci_O_Formi_Autorskog_Zapisa_Dela>...</Podaci_O_Formi_Autorskog_Zapisa_Dela></Sedam><Osam><Podnosioci><Zivi_Podnosioci><Ziv_Podnosilac><Ime>Marko</Ime><Prezime>Filipovic</Prezime><Adresa><Grad>Senta</Grad><Ulica>24. februara</Ulica><Broj>51</Broj></Adresa><Drzavljanstvo>Ilegalni imigrant</Drzavljanstvo></Ziv_Podnosilac></Zivi_Podnosioci><Mrtvi_Podnosioci><Mrtav_Podnosilac><Ime>Zivka</Ime><Prezime>Pantelic</Prezime><Godina_Smrti>2022</Godina_Smrti></Mrtav_Podnosilac><Mrtav_Podnosilac><Ime>Sava</Ime><Prezime>Pantelic</Prezime><Godina_Smrti>2022</Godina_Smrti></Mrtav_Podnosilac></Mrtvi_Podnosioci><Anonimni_Podnosioci><Anoniman_Podnosilac><Delo_Anonimnog_Autora>Mosotvi</Delo_Anonimnog_Autora></Anoniman_Podnosilac><Anoniman_Podnosilac><Delo_Anonimnog_Autora>Braca Ravnice</Delo_Anonimnog_Autora></Anoniman_Podnosilac></Anonimni_Podnosioci></Podnosioci></Osam><Devet><Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu>Nije</Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu></Devet><Deset><Nameravani_Nacin_Koriscenja_Autorskog_Dela>U fabrikama</Nameravani_Nacin_Koriscenja_Autorskog_Dela></Deset><Jedanaest><x:Potpis property=\'pred:Potpis\'>pot? pis...?</x:Potpis></Jedanaest><Dvanaest><Prilozi_Uz_Zahtev>Prinos za ponos, istitut za kukuruz MUNZE polje</Prilozi_Uz_Zahtev></Dvanaest><Opis_Autorskog_Dela>it just works (TM)</Opis_Autorskog_Dela><x:Broj_Prijace property=\'pred:Broj_Prijace\'>1564</x:Broj_Prijace><x:Datum_Podnosenja property=\'pred:Datum_Podnosenja\' >24.05.2022</x:Datum_Podnosenja>undefinedundefined</AJedan>';
    let text = '<AJedan xmlns:x=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:pred=\"https://1564.com/predicate\" xmlns=\'https://www.D_A_B_F#_G_D_G_A.com\'><Jedan><Podnosilac><Ime xml:space=\'preserve\'>Marko</Ime><Prezime xml:space=\'preserve\'>Savic</Prezime><Adresa><Grad xml:space=\'preserve\'>Srbobran</Grad><Ulica xml:space=\'preserve\'>Topolska</Ulica><Broj xml:space=\'preserve\'>18</Broj></Adresa><Telefonski_Broj xml:space=\'preserve\'>0645662322</Telefonski_Broj><Drzavljanstvo xml:space=\'preserve\'>Juznoafricka Republika</Drzavljanstvo></Podnosilac></Jedan><Dva><Znak_Autora xml:space=\'preserve\'>[ZNAK]</Znak_Autora></Dva><Tri><Punomocnik><Ime xml:space=\'preserve\'>Sava</Ime><Prezime xml:space=\'preserve\'>Babic</Prezime><Adresa><Grad xml:space=\'preserve\'>Ruski Krstur</Grad><Ulica xml:space=\'preserve\'>Ive Lole Ribara</Ulica><Broj xml:space=\'preserve\'>11</Broj></Adresa></Punomocnik></Tri><Cetiri><x:Naslov property=\'pred:Naslov\' xml:space=\'preserve\'>Patent 213441</x:Naslov><Alternativni_Naslov xml:space=\'preserve\'>Nas patetnt</Alternativni_Naslov></Cetiri><Pet><Autorsko_Delo_Prerade><Podaci_O_Originalnom_Autorskom_Delu xml:space=\'preserve\'>uzeto sa git huba</Podaci_O_Originalnom_Autorskom_Delu><Ime_Autora xml:space=\'preserve\'>Korisnik xXx_[iPr0]_HE4D5H00T_K1NG_BL4DEM45TER_420_xXx na git hubu</Ime_Autora></Autorsko_Delo_Prerade></Pet><Sest><x:Podaci_O_Vrsti_Autorskog_Dela property=\'pred:Podaci_O_Vrsti_Autorskog_Dela\' xml:space=\'preserve\'>Nacrt</x:Podaci_O_Vrsti_Autorskog_Dela></Sest><Sedam><Podaci_O_Formi_Autorskog_Zapisa_Dela xml:space=\'preserve\'>...</Podaci_O_Formi_Autorskog_Zapisa_Dela></Sedam><Osam><Podnosioci><Zivi_Podnosioci><Ziv_Podnosilac><Ime xml:space=\'preserve\'>Marko</Ime><Prezime xml:space=\'preserve\'>Filipovic</Prezime><Adresa><Grad xml:space=\'preserve\'>Senta</Grad><Ulica xml:space=\'preserve\'>24. februara</Ulica><Broj xml:space=\'preserve\'>51</Broj></Adresa><Drzavljanstvo xml:space=\'preserve\'>Ilegalni imigrant</Drzavljanstvo></Ziv_Podnosilac></Zivi_Podnosioci><Mrtvi_Podnosioci><Mrtav_Podnosilac><Ime xml:space=\'preserve\'>Zivka</Ime><Prezime xml:space=\'preserve\'>Pantelic</Prezime><Godina_Smrti xml:space=\'preserve\'>2022</Godina_Smrti></Mrtav_Podnosilac><Mrtav_Podnosilac><Ime xml:space=\'preserve\'>Sava</Ime><Prezime xml:space=\'preserve\'>Pantelic</Prezime><Godina_Smrti xml:space=\'preserve\'>2022</Godina_Smrti></Mrtav_Podnosilac></Mrtvi_Podnosioci><Anonimni_Podnosioci><Anoniman_Podnosilac><Delo_Anonimnog_Autora xml:space=\'preserve\'>Mosotvi</Delo_Anonimnog_Autora></Anoniman_Podnosilac><Anoniman_Podnosilac><Delo_Anonimnog_Autora xml:space=\'preserve\'>Braca Ravnice</Delo_Anonimnog_Autora></Anoniman_Podnosilac></Anonimni_Podnosioci></Podnosioci></Osam><Devet><Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu xml:space=\'preserve\'>Nije</Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu></Devet><Deset><Nameravani_Nacin_Koriscenja_Autorskog_Dela xml:space=\'preserve\'>U fabrikama</Nameravani_Nacin_Koriscenja_Autorskog_Dela></Deset><Jedanaest><x:Potpis property=\'pred:Potpis\' xml:space=\'preserve\'>pot? pis...?</x:Potpis></Jedanaest><Dvanaest><Prilozi_Uz_Zahtev xml:space=\'preserve\'>Prinos za ponos, istitut za kukuruz MUNZE polje</Prilozi_Uz_Zahtev></Dvanaest><Opis_Autorskog_Dela xml:space=\'preserve\'>it just works (TM)</Opis_Autorskog_Dela><x:Broj_Prijace property=\'pred:Broj_Prijace\' xml:space=\'preserve\'>1564</x:Broj_Prijace><x:Datum_Podnosenja property=\'pred:Datum_Podnosenja\' xml:space=\'preserve\'>24.05.2022</x:Datum_Podnosenja></AJedan>';
    //            <AJedan xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:pred=\"https://1564.com/predicate\" xsi:noNamespaceSchemaLocation=\"file:/C:/Users/User/Desktop/A-1.xsd\"
    const entity = new Entity();
    entity.text = text;
    console.log(entity);
    this.AJedanService.sendXml(entity);
    }

    posalji_GUI(){
        let text = '<AJedan xmlns:x=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:pred=\"https://1564.com/predicate\" xmlns=\'https://www.D_A_B_F#_G_D_G_A.com\'>'+
            '<Jedan>'+
                '<Podnosilac>'+
                    '<Ime xml:space=\'preserve\'>' + this.Postavi("ime1") + '</Ime>'+
                    '<Prezime xml:space=\'preserve\'>' + this.Postavi("prezime1") + '</Prezime>'+
                    '<Adresa>'+
                        '<Grad xml:space=\'preserve\'>' + this.Postavi("grad1") + '</Grad>'+
                        '<Ulica xml:space=\'preserve\'>' + this.Postavi("ulica1") + '</Ulica>'+
                        '<Broj xml:space=\'preserve\'>' + this.Postavi("broj1") + '</Broj>'+
                    '</Adresa>'+
                    '<Drzavljanstvo xml:space=\'preserve\'>' + this.Postavi("drzavljanstvo1") + '</Drzavljanstvo>'+
                '</Podnosilac>'+
                '<Telefonski_Broj xml:space=\'preserve\'>' + this.Postavi("telefon1") + '</Telefonski_Broj>'+
                '<email xml:space=\'preserve\'>' + this.Postavi("email1") + '</email>'+
            '</Jedan>'+
            '<Dva>';////////////////////////////////////////////////////////// JEDNO OD 2
            if (this.Postoji("broj1")){
                text += '<Znak_Autora xml:space=\'preserve\'>' + this.Postavi("znak1") + '</Znak_Autora>'////////OVO
            }else{
                text += '<Pseudonim xml:space=\'preserve\'>' + this.Postavi("pseudonim2") + '</Pseudonim>'////////OVO
            }
            text += '</Dva>'+
            '<Tri>';
            if (this.Postoji("ime3")){
                text += 
                '<Punomocnik>'+/////////////MOZDA GA NEMA
                    '<Ime xml:space=\'preserve\'>' + this.Postavi("ime3") + '</Ime>'+
                    '<Prezime xml:space=\'preserve\'>' + this.Postavi("prezime3") + '</Prezime>'+
                    '<Adresa>'+
                        '<Grad xml:space=\'preserve\'>' + this.Postavi("grad3") + '</Grad>'+
                        '<Ulica xml:space=\'preserve\'>' + this.Postavi("ulica3") + '</Ulica>'+
                        '<Broj xml:space=\'preserve\'>' + this.Postavi("broj3") + '</Broj>'+
                    '</Adresa>'+
                '</Punomocnik>';
            }
            text +=
            '</Tri>'+
            '<Cetiri>'+
                '<x:Naslov property=\'pred:Naslov\' xml:space=\'preserve\'>' + this.Postavi("naslov4") + '</x:Naslov>'+
                '<Alternativni_Naslov xml:space=\'preserve\'>' + this.Postavi("alternativni_naslov4") + '</Alternativni_Naslov>'+
            '</Cetiri>'+
            '<Pet>'+
                '<Autorsko_Delo_Prerade>'+
                    '<Podaci_O_Originalnom_Autorskom_Delu xml:space=\'preserve\'>' + this.Postavi("podaci_o_delu5") + '</Podaci_O_Originalnom_Autorskom_Delu>'+
                    '<Ime_Autora xml:space=\'preserve\'>' + this.Postavi("ime_autora5") + '</Ime_Autora>'+
                '</Autorsko_Delo_Prerade>'+
            '</Pet>'+
            '<Sest>'+
                '<x:Podaci_O_Vrsti_Autorskog_Dela property=\'pred:Podaci_O_Vrsti_Autorskog_Dela\' xml:space=\'preserve\'>' + this.Postavi("vrsta_dela6") + '</x:Podaci_O_Vrsti_Autorskog_Dela>'+
            '</Sest>'+
            '<Sedam>'+
                '<Podaci_O_Formi_Autorskog_Zapisa_Dela xml:space=\'preserve\'>' + this.Postavi("forma_dela7") + '</Podaci_O_Formi_Autorskog_Zapisa_Dela>'+
            '</Sedam>'+
            '<Osam>'+
                this.Osam() +
            '</Osam>'+
            '<Devet>'+
                '<Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu xml:space=\'preserve\'>' + this.Postavi("radni_odnos9") + '</Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu>'+
            '</Devet>'+
            '<Deset>'+
                '<Nameravani_Nacin_Koriscenja_Autorskog_Dela xml:space=\'preserve\'>' + this.Postavi("nacin_koriscenja10") + '</Nameravani_Nacin_Koriscenja_Autorskog_Dela>'+
            '</Deset>'+
            '<Jedanaest>'+
                '<x:Potpis property=\'pred:Potpis\' xml:space=\'preserve\'>' + this.Postavi("potpis11") + '</x:Potpis>'+
            '</Jedanaest>'+
            '<Dvanaest>'+
                '<Prilozi_Uz_Zahtev xml:space=\'preserve\'>' + this.Postavi("prilozi12") + '</Prilozi_Uz_Zahtev>'+
            '</Dvanaest>'+
            '<Opis_Autorskog_Dela xml:space=\'preserve\'>' + this.Postavi("opis") + '</Opis_Autorskog_Dela>'+
            '<x:Broj_Prijace property=\'pred:Broj_Prijace\' xml:space=\'preserve\'>A-' + this.Postavi("broj_prijave") + '</x:Broj_Prijace>'+
            '<x:Datum_Podnosenja property=\'pred:Datum_Podnosenja\' xml:space=\'preserve\'>' + this.datum() + '</x:Datum_Podnosenja>'+
        '</AJedan>';
        const entity = new Entity();
        entity.text = text;
        console.log(entity);
        //this.AJedanService.sendXml(entity);
        return this.http.post(this.path, entity, { responseType: 'text' }).subscribe(data => {
            console.log(data);
            if(data == "<Odgovor>Uspeh</Odgovor>"){
              console.log("Uspelo");
              alert("Zahtev je uspesno podnet")
              this.router.navigate(['/gradjaninPocetna'])
            }else if(data == "<Odgovor>Vec Postoji</Odgovor>"){
                console.log("Dokument vec postoji");
                alert("Dokument sa tim imenom vec postoji")
            }else{
              console.log("Nije uspelo");
              alert("Doslo je do greske pri prihvatanju zahteva, molimo vas proverite da li ste povezani na internet")
            }
          })
        
    }
    datum(){
        const today = new Date();
        const yyyy = today.getFullYear();
        let mm = today.getMonth() + 1; // Months start at 0!
        let dd = today.getDate();
        var mesec: number = +mm;
        var dan: number = +dd;
        let Odgovor = "";
        if ( dan < 10){ Odgovor += "0" + dd;}
        else{Odgovor += "" + dd;}
        if (mesec < 10){ Odgovor += '.' + "0" + mm;}
        else{Odgovor += '.' + mm;}
        Odgovor += '.' + yyyy;
        console.log("Datum stavljen na " + Odgovor)
        return Odgovor;
    }

    getCharacterLength(str:string) {

        return [...str].length;
      }

    Preuzmi_PDF(){
        let text = Xonomy.harvest();
        const entity = new Entity();
        entity.text = text;
        console.log(entity);
        //this.AJedanService.sendXml(entity);/////////////////////////TODO nije uradjeno
        return this.http.post(this.path, entity, { responseType: 'text' }).subscribe(data => {
            console.log(data);
            if(data == "<Odgovor>Uspeh</Odgovor>"){
              console.log("Uspelo");
              this.router.navigate(['/gradjaninPocetna'])
            }else{
              console.log("Nije uspelo");
              alert("Doslo je do greske pri prihvatanju zahteva, molimo vas proverite da li ste povezani na internet")
            }
          })
    }

}
