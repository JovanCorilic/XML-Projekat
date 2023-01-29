import { CreateResenjeComponent } from './RESENJE/create-resenje/create-resenje.component';
import { SvaResenjaComponent } from './RESENJE/sva-resenja/sva-resenja.component';
import { PretragaViseMetapodatakaComponent } from './PATENT/pretraga-vise-metapodataka/pretraga-vise-metapodataka.component';
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
    path : 'svi-patent-neprodjeni/:prodjeno',
    component: SviPatentComponent
  },
  {
    path: 'edit-patent/:patent/:prodjeno',
    component:EditPatentComponent
  },
  {
    path: 'pretragaViseMetapodataka/:prodjeno',
    component:PretragaViseMetapodatakaComponent
  },
  {
    path: 'svaResenja',
    component:SvaResenjaComponent
  },
  {
    path: 'createResenja',
    component:CreateResenjeComponent
  },
  {
    path: 'editResenja/:resenje',
    component:EditPatentComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {onSameUrlNavigation:'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
