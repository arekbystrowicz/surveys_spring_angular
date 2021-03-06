import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { Answer } from "../../model/answer";


@Injectable()
export class AnswerService {

  private originUrl = '//localhost:8080/questions';

  constructor(private http: HttpClient) { }

  public get(questionId: number, answerId: number): Observable<Answer> {
    return this.http.get<Answer>(this.getResourceUrl(questionId, answerId));
  }

  public getAll(questionId: number): Observable<Answer[]> {
    return this.http.get<Answer[]>(this.getResourceUrl(questionId, null));
  }

  public create(questionId: number, answer: Answer): Observable<Answer> {
    return this.http.post<Answer>(this.getResourceUrl(questionId, null), answer);
  }

  public update(questionId: number, answer: Answer): Observable<Answer> {
    return this.http.put<Answer>(this.getResourceUrl(questionId, answer.id), answer);
  }

  public delete(questionId: number, answer: Answer):  Observable<Answer> {
    return this.http.delete<Answer>(this.getResourceUrl(questionId, answer.id));
  }

  private getResourceUrl(questionId: number, answerId: number): string {
    let resourceUrl = `${this.originUrl}/${questionId}/answers`;
    if (answerId) {
      resourceUrl += `/${answerId}`;
    }

    return resourceUrl;
  }

}
