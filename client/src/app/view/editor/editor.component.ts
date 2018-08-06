import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { Survey } from "../../model/survey";
import { Question } from "../../model/question";

import { SurveyService } from "../../service/survey/survey.service";
import { QuestionService } from "../../service/question/question.service";


@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  @Input() survey: Survey;
  @Input() questions: Question[];

  constructor(private surveyService: SurveyService,
              private questionService: QuestionService,
              private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.getSurvey();
  }

  private getSurvey(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.surveyService.get(id)
      .subscribe(survey => this.survey = survey);
  }

  public updateSurvey() {
    this.surveyService.update(this.survey)
      .subscribe(survey => this.survey = survey);
  }

}
