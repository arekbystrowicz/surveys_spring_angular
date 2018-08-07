import { Component, Input, OnInit } from '@angular/core';

import { Answer } from "../../../model/answer";

import { AnswerService } from "../../../service/answer/answer.service";


@Component({
  selector: 'app-answer-form',
  templateUrl: './answer-form.component.html',
  styleUrls: ['./answer-form.component.css']
})
export class AnswerFormComponent implements OnInit {

  @Input() answer: Answer;
  @Input() questionId: number;

  constructor(private answerService: AnswerService) { }

  ngOnInit() {
  }

  public updateAnswer(): void {
    this.answerService.update(this.questionId, this.answer)
      .subscribe(answer => this.answer = answer);
  }

}
