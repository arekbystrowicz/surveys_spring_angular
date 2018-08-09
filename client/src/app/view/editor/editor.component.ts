import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { Question } from "../../model/question";

import { QuestionService } from "../../service/question/question.service";
import { SurveyForm } from "./form/form";


@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  questions: Question[];

  constructor(private form: SurveyForm,
              private questionService: QuestionService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getQuestions();
    this.form.init(+this.route.snapshot.paramMap.get('id'));
  }

  private getQuestions(): void {
    const surveyId = +this.route.snapshot.paramMap.get('id');
    this.questionService.getBySurveyId(surveyId)
      .subscribe(questions => this.questions = questions);
  }

}
