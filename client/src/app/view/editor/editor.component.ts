import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { Survey } from "../../model/survey";
import { Question } from "../../model/question";

import { SurveyService } from "../../service/survey/survey.service";
import { QuestionService } from "../../service/question/question.service";
import { SurveyForm } from "./form/form";


@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  survey: Survey;
  questions: Question[];

  constructor(private form: SurveyForm,
              private surveyService: SurveyService,
              private questionService: QuestionService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.getSurvey();
    this.getQuestions();
  }

  private getSurvey(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.surveyService.get(id)
      .subscribe(survey => this.survey = survey);
  }

  private getQuestions(): void {
    const surveyId = +this.route.snapshot.paramMap.get('id');
    this.questionService.getBySurveyId(surveyId)
      .subscribe(questions => this.questions = questions);
  }

}
