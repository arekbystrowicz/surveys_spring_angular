import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { Question } from "../../model/question";

@Injectable()
export class QuestionService {

  private originUrl = '//localhost:8080/questions';

  constructor(private http: HttpClient) { }

  public get(id: number): Observable<Question> {
    return this.http.get<Question>(`${this.originUrl}/${id}`);
  }

  public getAll(): Observable<Question[]> {
    return this.http.get<Question[]>(this.originUrl);
  }

  public create(question: Question): Observable<Question> {
    return this.http.post<Question>(this.originUrl, question);
  }

  public update(question: Question): Observable<Question> {
    return this.http.put<Question>(`${this.originUrl}/${question.id}`, question);
  }

  public delete(question: Question):  Observable<Question> {
    return this.http.delete<Question>(`${this.originUrl}/${question.id}`);
  }

}
