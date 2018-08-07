import { Component, OnInit } from '@angular/core';

import { AnswerService } from "../../../service/answer/answer.service";

@Component({
  selector: 'app-answer-form',
  templateUrl: './answer-form.component.html',
  styleUrls: ['./answer-form.component.css']
})
export class AnswerFormComponent implements OnInit {

  constructor(private answerService: AnswerService) { }

  ngOnInit() {
  }

}
