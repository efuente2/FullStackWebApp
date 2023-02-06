import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './pages/cart/cart.component';
import { HomeComponent } from './pages/home/home.component';
import { StartComponent } from './start/start/start.component';

const routes: Routes = [
  {path: "start", component:StartComponent},
  {path: "home", component:HomeComponent},
  {path: "cart", component:CartComponent},
  {path: "", redirectTo:"start", pathMatch:"full"}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
