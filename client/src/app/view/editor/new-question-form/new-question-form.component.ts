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
    this.isToggled = !this.isToggled
  }

  public update(): void {
    if (this.isFinished()) {
      
    }
  }

  private isFinished(): boolean {
    if (this.question.title !== "" && this.question.description !== "") {
      return true;
    }
  }

}
