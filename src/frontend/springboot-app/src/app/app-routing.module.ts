import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { MemberComponent } from './components/member/member.component';
import { StuffComponent } from './components/stuff/stuff.component';
import { LoaningComponent } from './components/loaning/loaning.component';

const routes: Routes = [
 {
  path: '',
  redirectTo: 'home',
  pathMatch: 'full'
 },
 {
  path: 'home',
  component: HomeComponent
 },
 {
  path: 'member',
  component: MemberComponent
 },
 {
  path: 'stuff',
  component: StuffComponent
 },
 {
  path: 'loaning',
  component: LoaningComponent
 },
 {
  path: '**',
  redirectTo: 'home'
 }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
