import { LoginComponent } from './components/login/login.component';
import { EmployeeHomePageComponent } from './components/employee-home-page/employee-home-page.component';
import { CitizenHomePageComponent } from './components/citizen-home-page/citizen-home-page.component';
import { TrademarkFormComponent } from './components/trademark-form/trademark-form.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [

  { path: 'login', component: LoginComponent },
  { path: 'trademark', component: TrademarkFormComponent },
  { path: 'citizen-home', component: CitizenHomePageComponent },
  { path: 'employee-home', component: EmployeeHomePageComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
