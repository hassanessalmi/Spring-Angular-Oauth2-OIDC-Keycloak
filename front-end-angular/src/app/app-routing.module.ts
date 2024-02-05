import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProductsComponent} from "./ui/products/products.component";
import {augmentIndexHtml} from "@angular-devkit/build-angular/src/utils/index-file/augment-index-html";
import {AuthGuard} from "./guards/auth.guard";


const routes: Routes = [{ path:"products",component:ProductsComponent,canActivate:[AuthGuard],data:{roles:['ADMIN']}}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
