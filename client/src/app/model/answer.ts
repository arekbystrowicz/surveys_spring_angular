import { Question } from "./question";

export class Answer {
  id: number;
  description: string;
  isAccessible: boolean;
  question: Question;
  createdAt: Date;
  updatedAt: Date;
}
