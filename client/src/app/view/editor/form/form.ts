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
  questions: Map<Question, Answer[]> = new Map<Question, Answer[]>();

  constructor(private surveyService: SurveyService,
              private questionService: QuestionService,
              private answerService: AnswerService) {
  }

  public init(surveyId: number): void {
    this.setSurvey(surveyId);
    this.setQuestions(surveyId);
  }

  private setSurvey(surveyId: number): void {
    this.surveyService.get(surveyId)
      .subscribe(survey => this.survey = survey);
  }

  private setQuestions(surveyId: number): void {
    this.questionService.getBySurveyId(surveyId)
      .subscribe(questions => {
        for (let question of questions) {
          this.mapQuestionsWithAnswers(question);
        }
      });
  }

  private mapQuestionsWithAnswers(question: Question): void {
    this.answerService.getAll(question.id)
      .subscribe(answers => this.questions.set(question, answers));
  }

}
