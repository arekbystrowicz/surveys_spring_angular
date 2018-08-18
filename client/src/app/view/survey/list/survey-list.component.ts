import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";

import { Survey } from "../../../model/survey";
import { SurveyService } from "../../../service/survey/survey.service";


@Component({
  selector: 'app-survey-list',
  templateUrl: './survey-list.component.html',
  styleUrls: ['./survey-list.component.css']
})
export class SurveyListComponent implements OnInit {

  surveys: Survey[];

  constructor(private http: HttpClient,
              private router: Router,
              private surveyService: SurveyService) { }

  ngOnInit() {
    this.getAll();
  }

  private getAll(): void {
    this.surveyService.getAll().subscribe(surveys => {
      this.surveys = surveys;
    });
  }

  public redirectToSurveyPage(survey: Survey): void {
    this.router.navigate([`/surveys/${survey.id}`]);
  }

}
