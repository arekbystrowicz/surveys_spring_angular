import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../../logic/form";

import { Survey } from "../../../../model/survey";


@Component({
  selector: 'app-new-survey-form',
  templateUrl: './new-survey-form.component.html',
  styleUrls: ['./new-survey-form.component.css']
})
export class NewSurveyFormComponent implements OnInit {

  @Input() form: SurveyForm;
  @Input() survey: Survey;

  constructor() { }

  ngOnInit() {
  }

  public create(): void {
    if (this.survey.title && this.survey.description) {
      this.form.createSurvey(this.survey);
    }
  }

}
