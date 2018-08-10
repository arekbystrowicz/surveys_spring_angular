import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../form/form";


@Component({
  selector: 'app-new-question-form',
  templateUrl: './new-question-form.component.html',
  styleUrls: ['./new-question-form.component.css']
})
export class NewQuestionFormComponent implements OnInit {

  @Input() form: SurveyForm;

  constructor() { }

  ngOnInit() {
  }

}
