import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { Survey } from "../../model/survey";


@Injectable()
export class SurveyService {

  private originUrl = '//localhost:8080/categories';

  constructor(private http: HttpClient) { }

  public get(id: number): Observable<Survey> {
    return this.http.get<Survey>(`${this.originUrl}/${id}`);
  }

  public getAll(): Observable<Survey[]> {
    return this.http.get<Survey[]>(this.originUrl);
  }

  public create(survey: Survey): Observable<Survey> {
    return this.http.post<Survey>(this.originUrl, survey);
  }

  public update(survey: Survey): Observable<Survey> {
    return this.http.put<Survey>(`${this.originUrl}/${survey.id}`, survey);
  }

  public delete(survey: Survey):  Observable<Survey> {
    return this.http.delete<Survey>(`${this.originUrl}/${survey.id}`);
  }

}
