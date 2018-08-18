import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../../logic/form";
import { Question } from "../../../../model/question";


@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {

  @Input() question: Question;
  @Input() form: SurveyForm;

  constructor() {
  }

  ngOnInit() {
  }

  public updateQuestion() {
    this.form.updateQuestion(this.question);
  }

  public deleteQuestion() {
    this.form.deleteQuestion(this.question);
  }

}
