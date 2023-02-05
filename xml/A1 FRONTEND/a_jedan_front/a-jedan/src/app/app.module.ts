import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateA1Component } from './create-a1/create-a1.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { GradjaninComponent } from './gradjanin/gradjanin.component';
import { SluzbenikComponent } from './sluzbenik/sluzbenik.component';
import { PrihvatiA1SluzbenikComponent } from './prihvati-a1-sluzbenik/prihvati-a1-sluzbenik.component';
import { PrihvatiOdabravniA1SluzbenikComponent } from './prihvati-odabravni-a1-sluzbenik/prihvati-odabravni-a1-sluzbenik.component';
import { PregledA1SluzbenikComponent } from './pregled-a1-sluzbenik/pregled-a1-sluzbenik.component';
import { ProgledajDokumentComponent } from './progledaj-dokument/progledaj-dokument.component';
import { PretraziMetadataComponent } from './pretrazi-metadata/pretrazi-metadata.component';
import { ZvestajComponent } from './zvestaj/zvestaj.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateA1Component,
    LoginComponent,
    GradjaninComponent,
    SluzbenikComponent,
    PrihvatiA1SluzbenikComponent,
    PrihvatiOdabravniA1SluzbenikComponent,
    PregledA1SluzbenikComponent,
    ProgledajDokumentComponent,
    PretraziMetadataComponent,
    ZvestajComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
