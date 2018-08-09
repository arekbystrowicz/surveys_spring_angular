import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../form/form";
import { Question } from "../../../model/question";


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

  // private getNewAnswerInput(): HTMLElement {
  //   return document.getElementById(this.question.id + '-new-answer-input');
  // }
  //
  // private getNewAnswerButton(): HTMLElement {
  //   return document.getElementById(this.question.id + '-new-answer-button');
  // }
  //
  // private getNewAnswerSubmitButton(): HTMLElement {
  //   return document.getElementById(this.question.id + '-new-answer-submit-button');
  // }
  //
  // private toggleOn(): void {
  //   this.getNewAnswerInput().setAttribute('type', 'text');
  //   this.getNewAnswerButton().style.display = 'none';
  //   this.getNewAnswerSubmitButton().className = "inline-block";
  // }
  //
  // private toggleOff(): void {
  //   this.getNewAnswerInput().setAttribute('type', 'hidden');
  //   this.getNewAnswerButton().style.display = 'block';
  //   this.getNewAnswerSubmitButton().className = "invisible";
  // }
  // public createAnswer(): void {
  //   this.answerService.create(this.question.id, this.newAnswer)
  //     .subscribe(answer => this.answers.push(answer));
  //
  //   this.newAnswer = new Answer();
  // }

}
