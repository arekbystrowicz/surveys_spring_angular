import { Injectable } from "@angular/core";

import { Survey } from "../../../model/survey";
import { Question } from "../../../model/question";
import { Answer } from "../../../model/answer";

import { SurveyService } from "../../../service/survey/survey.service";
import { QuestionService } from "../../../service/question/question.service";
import { AnswerService } from "../../../service/answer/answer.service";


@Injectable()
export class SurveyForm {

  survey: Survey;
  questions: Map<Question, Answer>;

  constructor(private surveyService: SurveyService,
              private questionService: QuestionService,
              private answerService: AnswerService) {
  }

}
