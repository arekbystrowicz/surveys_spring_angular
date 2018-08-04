import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";

import { AppComponent } from './app.component';

import { UserService } from "./service/user/user.service";
import { CategoryService } from "./service/category/category.service";
import { SurveyService } from "./service/survey.service";
import { QuestionService } from "./service/question/question.service";
import { AnswerService } from "./service/answer/answer.service";

import { UserProfileComponent } from './view/user/profile/user-profile.component';
import { AppRoutingModule } from './/app-routing.module';
import { UserBadgeComponent } from './view/user/badge/user-badge.component';
import { UserListComponent } from './view/user/list/user-list.component';
import { SurveyListComponent } from './view/survey/list/surevy-list.component';


@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent,
    UserBadgeComponent,
    UserListComponent,
    SurveyListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    UserService,
    CategoryService,
    SurveyService,
    QuestionService,
    AnswerService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
