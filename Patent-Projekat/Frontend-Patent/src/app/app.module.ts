import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav'
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { EditPatentComponent } from './PATENT/edit-patent/edit-patent.component';
import { PatentCreateComponent } from './PATENT/patent-create/patent-create.component';
import { SviPatentComponent } from './PATENT/svi-patent/svi-patent.component';
import { NgSelectModule } from '@ng-select/ng-select';
import { Interceptor } from './SERVICE/intercept.service';
import { SvaResenjaComponent } from './RESENJE/sva-resenja/sva-resenja.component';
import { EditResenjeComponent } from './RESENJE/edit-resenje/edit-resenje.component';
import { CreateResenjeComponent } from './RESENJE/create-resenje/create-resenje.component';
import { PretragaViseMetapodatakaComponent } from './PATENT/pretraga-vise-metapodataka/pretraga-vise-metapodataka.component';
import { RegistracijaComponent } from './SECURITY/registracija/registracija.component';
import { LoginComponent } from './SECURITY/login/login.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    EditPatentComponent,
    PatentCreateComponent,
    SviPatentComponent,
    SvaResenjaComponent,
    EditResenjeComponent,
    CreateResenjeComponent,
    PretragaViseMetapodatakaComponent,
    RegistracijaComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    NgSelectModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    BrowserAnimationsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: Interceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
