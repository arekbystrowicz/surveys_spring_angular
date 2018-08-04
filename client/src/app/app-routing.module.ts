import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserProfileComponent } from "./view/user/profile/user-profile.component";
import { UserListComponent } from "./view/user/list/user-list.component";
import { SurveyListComponent } from "./view/survey/list/survey-list.component";


const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'users/:id', component: UserProfileComponent },
  { path: 'surveys', component: SurveyListComponent }
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
