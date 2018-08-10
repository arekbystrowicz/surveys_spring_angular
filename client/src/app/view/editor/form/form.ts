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
    this.questionService.getBySurveyId(1)
      .subscribe(questions => {
        this.mapQuestionsWithAnswers(Array.from(questions));
      });
  }

  private mapQuestionsWithAnswers(questions: Question[]): void {
    for (let question of questions) {
      this.answerService.getAll(question.id)
        .subscribe(answers => this.questions.set(question, answers));
    }
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

  public updateSurvey(survey: Survey): void {
    this.surveyService.update(this.survey)
      .subscribe(response => this.survey = response);
  }

  public updateQuestion(question: Question): void {
  // performed by object reference
    this.questionService.update(question)
      .subscribe(response => question = response);
  }

  public updateAnswer(question: Question, answer: Answer): void {
    // performed by object reference
    this.answerService.update(question.id, answer)
      .subscribe(response => answer = response);
  }

  public deleteQuestion(question: Question): void {

  }

  public deleteAnswer(question: Question, answer: Answer): void {

  }

}
