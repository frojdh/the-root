import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HelloworldComponent} from "./component/helloworld/helloworld.component";

const routes: Routes = [
  { path: 'helloworld', component: HelloworldComponent },
  { path: '', redirectTo: '/helloworld', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
