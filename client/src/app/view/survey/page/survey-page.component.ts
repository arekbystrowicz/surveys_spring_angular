import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { Survey } from "../../../model/survey";
import { SurveyService } from "../../../service/survey.service";


@Component({
  selector: 'app-survey-page',
  templateUrl: './survey-page.component.html',
  styleUrls: ['./survey-page.component.css']
})
export class SurveyPageComponent implements OnInit {

  private survey: Survey;

  constructor(private surveyService: SurveyService, private route: ActivatedRoute) { }

  ngOnInit() {
  }

  private get(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.surveyService.get(id)
      .subscribe(survey => this.survey = survey);
  }

}
