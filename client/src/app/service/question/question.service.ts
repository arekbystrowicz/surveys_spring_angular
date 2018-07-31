import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class QuestionService {

  private originUrl = '//localhost:8080/questions';

  constructor(private http: HttpClient) { }

}
