import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class SurveyService {

  constructor(private http: HttpClient) { }

}
