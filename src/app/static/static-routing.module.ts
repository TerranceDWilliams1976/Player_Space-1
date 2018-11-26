import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AboutComponent } from './about/about.component';
import { FeaturesComponent } from './features/features.component';
import { WantComponent } from './want/want.component';
import {HaveComponent} from './have/have.component';
import {HadComponent} from './had/had.component';


const routes: Routes = [
  {
    path: 'about',
    component: AboutComponent,
    data: { title: 'anms.menu.about' }
  },
  {
    path: 'features',
    component: FeaturesComponent,
    data: { title: 'anms.menu.features' }
  },
  {
    path: 'want',
    component: WantComponent,
    data: { title: 'anms.menu.want' }
  },
  {
    path: 'have',
    component: HaveComponent,
    data: { title: 'anms.menu.have' }
  },
  {
    path: 'had',
    component: HadComponent,
    data: { title: 'anms.menu.had' }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StaticRoutingModule {}
