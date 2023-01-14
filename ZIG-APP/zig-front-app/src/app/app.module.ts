import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TrademarkFormComponent } from './components/trademark-form/trademark-form.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CitizenMenuComponent } from './components/citizen-menu/citizen-menu.component';
import { ReactiveFormsModule } from '@angular/forms';
import { MatMenuModule } from '@angular/material/menu';
import { NgbNavModule } from '@ng-bootstrap/ng-bootstrap';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { EmployeeHomePageComponent } from './components/employee-home-page/employee-home-page.component';
import { CitizenHomePageComponent } from './components/citizen-home-page/citizen-home-page.component';
import { EmployeeMenuComponent } from './components/employee-menu/employee-menu.component';
import { LoginComponent } from './components/login/login.component';
import { SolutionComponent } from './components/solution/solution.component';
import { FormTableComponent } from './components/form-table/form-table.component';

@NgModule({
  declarations: [
    AppComponent,
    TrademarkFormComponent,
    CitizenMenuComponent,
    EmployeeHomePageComponent,
    CitizenHomePageComponent,
    EmployeeMenuComponent,
    LoginComponent,
    SolutionComponent,
    FormTableComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatMenuModule,
    NgbNavModule,
    MDBBootstrapModule.forRoot()

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
