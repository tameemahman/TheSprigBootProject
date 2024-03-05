import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ProductComponent } from './components/product/product.component';
import { CategoryComponent } from './components/category/category.component';
import { ProductsAllComponent } from './components/products-all/products-all.component';
import { CartComponent } from './components/cart/cart.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'products', component: ProductComponent },
  { path: 'categories', component: CategoryComponent },
  { path: 'productall', component: ProductsAllComponent },
  { path: 'cart', component: CartComponent },
  
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
