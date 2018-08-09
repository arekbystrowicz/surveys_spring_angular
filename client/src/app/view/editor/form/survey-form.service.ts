import { Injectable } from '@angular/core';

import { Survey } from "../../../model/survey";
import { Answer } from "../../../model/answer";
import { Question } from "../../../model/question";

import { SurveyService } from "../../../service/survey/survey.service";
import { QuestionService } from "../../../service/question/question.service";
import { AnswerService } from "../../../service/answer/answer.service";


@Injectable()
export class SurveyFormService {

  private survey: Survey;
  private questions: Map<Question, Answer[]>;

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
          this.mapQuestionWithAnswers(question);
        }
      });
  }

  private mapQuestionWithAnswers(question: Question): void {
    this.answerService.getAll(question.id)
      .subscribe(answer => this.questions.set(question, answer));
  }

  public getSurvey(): Survey {
    return this.survey;
  }

  public getQuestions(): Question[] {
    return Array.from(this.questions.keys());
  }

  public getAnswers(question: Question): Answer[] {
    return this.questions.get(question);
  }

  public createQuestion(question: Question): void {
    this.questionService.create(question)
      .subscribe(response => this.questions.set(response, []));
  }

  public createAnswer(question: Question, answer: Answer): void {
    this.answerService.create(question.id, answer)
      .subscribe(response => this.questions.get(question).push(response))
  }

  // update(...) methods use object references
  public updateSurvey(survey: Survey): void {
    this.surveyService.update(survey)
      .subscribe(response => survey = response);
  }

  public updateQuestion(question: Question): void {
    this.questionService.update(question)
      .subscribe(response => question = response)
  }

  public updateAnswer(questionId: number, answer: Answer): void {
    this.answerService.update(questionId, answer)
      .subscribe(response => answer = response);
  }

}
