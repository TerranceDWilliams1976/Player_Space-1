import { NgModule } from "@angular/core";

import { SharedModule } from "@app/shared";

import { StaticRoutingModule } from "./static-routing.module";
import { AboutComponent } from "./about/about.component";
import { FeaturesComponent } from "./features/features.component";
import { WantComponent } from "./want/want.component";
import { HaveComponent } from "./have/have.component";
import { HadComponent } from "./had/had.component";
// import { WantComponent } from './want/want.component';

@NgModule({
  imports: [SharedModule, StaticRoutingModule],
  declarations: [
    AboutComponent,
    FeaturesComponent,
    WantComponent,
    HaveComponent,
    HadComponent
  ]
})
export class StaticModule {}
