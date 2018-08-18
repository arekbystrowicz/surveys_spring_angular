import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../../logic/form";
import { Survey } from "../../../../model/survey";

@Component({
  selector: 'app-survey-form',
  templateUrl: './survey-form.component.html',
  styleUrls: ['./survey-form.component.css']
})
export class SurveyFormComponent implements OnInit {

  @Input() form: SurveyForm;
  @Input() survey: Survey;

  constructor() { }

  ngOnInit() {
  }

  public updateSurvey(): void {
    this.form.updateSurvey(this.survey);
  }

}
