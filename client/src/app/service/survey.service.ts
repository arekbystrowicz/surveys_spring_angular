import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SurveyService {

  constructor(private http: HttpClient) { }

  public getAll(): Observable<any> {
    return this.http.get('//localhost:8080/surveys');
  }

  public get(id: number) {
    return this.http.get('//localhost:8080/surveys/' + id);
  }

}
