import { Component, Input, OnInit } from '@angular/core';

import { Question } from "../../../model/question";
// import { Answer } from "../../../model/answer";
//
// import { QuestionService } from "../../../service/question/question.service";
// import { AnswerService } from "../../../service/answer/answer.service";
import { SurveyForm } from "../form/form";

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {

  @Input() question: Question;
  @Input() form: SurveyForm;
  // answers: Answer[];
  // newAnswer: Answer = new Answer();
  //
  // constructor(private questionService: QuestionService, private answerService: AnswerService) {
  // }

  constructor() {
  }

  ngOnInit() {
  }

  public updateQuestion() {
    this.form.updateQuestion(this.question);
  }

  // ngOnInit() {
  //    this.getAnswers();
  // }

  // private getAnswers(): void {
  //   this.answerService.getAll(this.question.id)
  //     .subscribe(answers => this.answers = answers);
  // }

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

  // public updateQuestion(): void {
  //   this.questionService.update(this.question)
  //     .subscribe(question => this.question = question);
  // }
  //
  // public createAnswer(): void {
  //   this.answerService.create(this.question.id, this.newAnswer)
  //     .subscribe(answer => this.answers.push(answer));
  //
  //   this.newAnswer = new Answer();
  // }

}
