import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateA1Component } from './create-a1/create-a1.component';
import { GradjaninComponent } from './gradjanin/gradjanin.component';
import { LoginComponent } from './login/login.component';
import { PregledA1SluzbenikComponent } from './pregled-a1-sluzbenik/pregled-a1-sluzbenik.component';
import { PretraziMetadataComponent } from './pretrazi-metadata/pretrazi-metadata.component';
import { PrihvatiA1SluzbenikComponent } from './prihvati-a1-sluzbenik/prihvati-a1-sluzbenik.component';
import { PrihvatiOdabravniA1SluzbenikComponent } from './prihvati-odabravni-a1-sluzbenik/prihvati-odabravni-a1-sluzbenik.component';
import { ProgledajDokumentComponent } from './progledaj-dokument/progledaj-dokument.component';
import { SluzbenikComponent } from './sluzbenik/sluzbenik.component';
import { ZvestajComponent } from './zvestaj/zvestaj.component';

const routes: Routes = [
  {path:"",component:LoginComponent},
  {path:"gradjaninPocetna",component:GradjaninComponent},
  {path:"sluzbenikPocetna",component:SluzbenikComponent},
  {path:"sluzbenikPrihvatiDokument",component:PrihvatiOdabravniA1SluzbenikComponent},
  {path:"sluzbenikPregledajA1",component:PregledA1SluzbenikComponent},
  {path:"sluzbenikPregledajMetadataA1",component:PretraziMetadataComponent},
  {path:"PogledajDokument",component:ProgledajDokumentComponent},
  {path:"Izvestaj",component:ZvestajComponent},
  {path:"sluzbenikPrihvati",component:PrihvatiA1SluzbenikComponent},
  {path:"createA1",component:CreateA1Component},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
