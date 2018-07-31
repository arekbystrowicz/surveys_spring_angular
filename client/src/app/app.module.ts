import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from "@angular/common/http";

import { AppComponent } from './app.component';

import { UserService } from "./service/user/user.service";
import { CategoryService } from "./service/category/category.service";


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    UserService,
    CategoryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
