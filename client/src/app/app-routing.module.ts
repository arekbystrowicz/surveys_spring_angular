import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserProfileComponent } from "./view/user/profile/user-profile.component";


const routes: Routes = [
// { path: 'users', component: UserProfileComponent },
  { path: 'users/:id', component: UserProfileComponent }
];


@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
