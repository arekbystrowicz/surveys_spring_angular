import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../form/form";
import { Answer } from "../../../model/answer";


@Component({
  selector: 'app-answer-form',
  templateUrl: './answer-form.component.html',
  styleUrls: ['./answer-form.component.css']
})
export class AnswerFormComponent implements OnInit {

  @Input() form : SurveyForm;
  @Input() answer: Answer;
  @Input() questionId: number;

  constructor() {
  }

  ngOnInit() {
  }

  public updateAnswer(answer: Answer): void {
    this.form.updateAnswer(this.questionId, this.answer);
  }

}
