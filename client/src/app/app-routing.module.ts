import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserProfileComponent } from "./view/user/profile/user-profile.component";
import { UserListComponent } from "./view/user/list/user-list.component";
import { SurveyListComponent } from "./view/survey/list/survey-list.component";
import { SurveyPageComponent } from "./view/survey/page/survey-page.component";
import { EditorComponent } from "./view/editor/editor.component";


const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'users/:id', component: UserProfileComponent },
  { path: 'surveys', component: SurveyListComponent },
  { path: 'surveys/:id', component: SurveyPageComponent },
  { path: 'editor?survey_id=:id', component: EditorComponent}
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
