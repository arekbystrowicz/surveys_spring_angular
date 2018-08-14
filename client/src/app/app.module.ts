import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';

import { UserService } from "./service/user/user.service";
import { CategoryService } from "./service/category/category.service";
import { SurveyService } from "./service/survey/survey.service";
import { QuestionService } from "./service/question/question.service";
import { AnswerService } from "./service/answer/answer.service";

import { UserProfileComponent } from './view/user/profile/user-profile.component';
import { AppRoutingModule } from './/app-routing.module';
import { UserBadgeComponent } from './view/user/badge/user-badge.component';
import { UserListComponent } from './view/user/list/user-list.component';
import { SurveyListComponent } from './view/survey/list/survey-list.component';
import { SurveyPageComponent } from './view/survey/page/survey-page.component';
import { EditorComponent } from './view/editor/editor.component';
import { SurveyFormComponent } from './view/editor/survey-form/survey-form.component';
import { QuestionFormComponent } from './view/editor/question-form/question-form.component';
import { AnswerFormComponent } from './view/editor/answer-form/answer-form.component';
import { SurveyForm } from "./view/editor/form/form";
import { NewAnswerFormComponent } from './view/editor/new-answer-form/new-answer-form.component';
import { NewQuestionFormComponent } from './view/editor/new-question-form/new-question-form.component';


@NgModule({
  declarations: [
    AppComponent,
    UserProfileComponent,
    UserBadgeComponent,
    UserListComponent,
    SurveyListComponent,
    SurveyPageComponent,
    EditorComponent,
    SurveyFormComponent,
    QuestionFormComponent,
    AnswerFormComponent,
    NewAnswerFormComponent,
    NewQuestionFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    UserService,
    CategoryService,
    SurveyService,
    QuestionService,
    AnswerService,
    SurveyForm
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
