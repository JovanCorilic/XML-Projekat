import { EditPatentComponent } from './PATENT/edit-patent/edit-patent.component';

import { PatentCreateComponent } from './PATENT/patent-create/patent-create.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SviPatentComponent } from './PATENT/svi-patent/svi-patent.component';

const routes: Routes = [
  {
    path:'patent-create',
    component : PatentCreateComponent
  },
  {
    path : 'svi-patent/:prodjeno',
    component: SviPatentComponent
  },
  {
    path: 'edit-patent/:patent',
    component:EditPatentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation:'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
