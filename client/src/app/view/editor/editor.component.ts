import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { Survey } from "../../model/survey";
import { SurveyService } from "../../service/survey/survey.service";


@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  survey: Survey;

  constructor(private surveyService: SurveyService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getSurvey();
  }

  private getSurvey(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.surveyService.get(id)
      .subscribe(survey => this.survey = survey);
  }

}
