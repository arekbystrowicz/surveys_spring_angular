import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { Survey } from "../../model/survey";
import { Category } from "../../model/category";


@Injectable()
export class SurveyService {

  private originUrl = '//localhost:8080/surveys';

  constructor(private http: HttpClient) { }

  public get(id: number): Observable<Survey> {
    return this.http.get<Survey>(`${this.originUrl}/${id}`);
  }

  public getAll(): Observable<Survey[]> {
    return this.http.get<Survey[]>(this.originUrl);
  }

  public create(survey: Survey): Observable<Survey> {
    // TODO do user login!
    return this.http.post<Survey>(`${this.originUrl}?user_id=1`, survey);
  }

  public update(survey: Survey): Observable<Survey> {
    return this.http.put<Survey>(`${this.originUrl}/${survey.id}`, survey);
  }

  public delete(survey: Survey):  Observable<Survey> {
    return this.http.delete<Survey>(`${this.originUrl}/${survey.id}`);
  }

  public addCategory(survey: Survey, category: Category): Observable<Survey> {
    // TODO fix server-side (put mapping)
    return this.http.put<Survey>(`${this.originUrl}/${survey.id}/categories/${category.id}`, category)
  }

  public removeCategory(survey: Survey, category: Category): Observable<Survey> {
    return this.http.delete<Survey>(`${this.originUrl}/${survey.id}/categories/${category.id}`)
  }

}
