import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { Question } from "../../model/question";


@Injectable()
export class QuestionService {

  private originUrl = '//localhost:8080/surveys';

  constructor(private http: HttpClient) { }

  public get(surveyId: number, questionId: number): Observable<Question> {
    return this.http.get<Question>(this.getResourceUrl(surveyId, questionId));
  }

  public getAll(surveyId: number): Observable<Question[]> {
    return this.http.get<Question[]>(this.getResourceUrl(surveyId, null));
  }

  public create(surveyId: number, question: Question): Observable<Question> {
    console.log(this.getResourceUrl(surveyId, null));
    return this.http.post<Question>(this.getResourceUrl(surveyId, null), question);
  }

  public update(surveyId: number, question: Question): Observable<Question> {
    return this.http.put<Question>(this.getResourceUrl(surveyId, question.id), question);
  }

  public delete(surveyId: number, question: Question):  Observable<Question> {
    return this.http.delete<Question>(this.getResourceUrl(surveyId, question.id));
  }

  private getResourceUrl(surveyId: number, questionId: number): string {
    let url = `${this.originUrl}/${surveyId}/questions`;
    if (questionId) {
      url += `/${questionId}`;
    }

    return url;
  }

}
