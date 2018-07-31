import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { Survey } from "../../model/survey";


@Injectable()
export class SurveyService {

  private originUrl = '//localhost:8080/categories';

  constructor(private http: HttpClient) { }

}
