import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { Answer } from "../../model/answer";


@Injectable()
export class AnswerService {

  private originUrl = '//localhost:8080/questions';

  constructor(private http: HttpClient) { }

}
