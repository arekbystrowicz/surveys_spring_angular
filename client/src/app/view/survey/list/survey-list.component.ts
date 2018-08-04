import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { Survey } from "../../../model/survey";
import { SurveyService } from "../../../service/survey.service";


@Component({
  selector: 'app-survey-list',
  templateUrl: './survey-list.component.html',
  styleUrls: ['./survey-list.component.css']
})
export class SurveyListComponent implements OnInit {

  private surveys: Survey[];

  constructor(private http: HttpClient, private surveyService: SurveyService) { }

  private getAll(): void {
    this.surveyService.getAll().subscribe(surveys => {
      this.surveys = surveys;
    });
  }

  ngOnInit() {
  }

}
