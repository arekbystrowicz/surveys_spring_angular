import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../form/form";

@Component({
  selector: 'app-survey-form',
  templateUrl: './survey-form.component.html',
  styleUrls: ['./survey-form.component.css']
})
export class SurveyFormComponent implements OnInit {

  @Input() form: SurveyForm;

  constructor() { }

  ngOnInit() {
  }

  public updateSurvey(): void {
    this.form.updateSurvey();
  }

}
