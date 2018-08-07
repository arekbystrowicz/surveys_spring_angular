import { Component, Input, OnInit } from '@angular/core';

import { Survey } from "../../../model/survey";

@Component({
  selector: 'app-survey-form',
  templateUrl: './survey-form.component.html',
  styleUrls: ['./survey-form.component.css']
})
export class SurveyFormComponent implements OnInit {

  @Input() survey: Survey;

  constructor() { }

  ngOnInit() {
  }

}
