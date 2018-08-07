import { Component, Input, OnInit } from '@angular/core';

import { Question } from "../../../model/question";
import { QuestionService } from "../../../service/question/question.service";

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {

  @Input() question: Question;

  constructor(private questionService: QuestionService) { }

  ngOnInit() {
  }

  public updateQuestion(): void {
    this.questionService.update(this.question)
      .subscribe(question => this.question = question);
  }

}
