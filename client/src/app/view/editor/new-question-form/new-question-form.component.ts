import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../form/form";
import { Question } from "../../../model/question";


@Component({
  selector: 'app-new-question-form',
  templateUrl: './new-question-form.component.html',
  styleUrls: ['./new-question-form.component.css']
})
export class NewQuestionFormComponent implements OnInit {

  @Input() form: SurveyForm;

  isToggled: boolean = false;
  question: Question = new Question();

  constructor() { }

  ngOnInit() {
  }

  public toggle(): void {
    if (this.isToggled === false) {
      this.isToggled = true;
    } else {
      // TODO check if both description and title are ze done
    }
  }

}
