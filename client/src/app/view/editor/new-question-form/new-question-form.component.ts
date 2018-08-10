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
      // TODO should use subscription pipe tap and err otherwise will not work well if there is no server response
      this.form.createQuestion(this.question);
      this.toggle();
      this.question = new Question();
    }
  }

  private isFinished(): boolean {
    if (this.question.title !== "" && this.question.description !== "") {
      return true;
    }
  }

}
