import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { Answer } from "../../model/answer";


@Injectable()
export class AnswerService {

  private originUrl = '//localhost:8080/questions';

  constructor(private http: HttpClient) { }

  public get(answerId: number, questionId: number): Observable<Answer> {
    return this.http.get<Answer>(this.getResourceUrl(questionId, answerId));
  }

  private getResourceUrl(questionId: number, answerId: number): string {
    let resourceUrl = `${this.originUrl}/${questionId}/answers`;
    if (answerId) {
      resourceUrl += `/${answerId}`;
    }

    return resourceUrl;
  }

}
