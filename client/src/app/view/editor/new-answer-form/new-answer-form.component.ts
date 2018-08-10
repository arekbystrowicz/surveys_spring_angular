import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../form/form";
import { Question } from "../../../model/question";
import { Answer } from "../../../model/answer";


@Component({
  selector: 'app-new-answer-form',
  templateUrl: './new-answer-form.component.html',
  styleUrls: ['./new-answer-form.component.css']
})
export class NewAnswerFormComponent implements OnInit {

  @Input() form: SurveyForm;
  @Input() question: Question;

  isToggled: boolean = false;
  answer: Answer = new Answer();

  constructor() { }

  ngOnInit() {
  }

  public toggle() {
    this.isToggled = !this.isToggled;
  }

}
