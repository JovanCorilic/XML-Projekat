import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateA1Component } from './create-a1/create-a1.component';

const routes: Routes = [{path:"",component:CreateA1Component}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
