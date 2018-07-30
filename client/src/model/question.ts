import { Survey } from "./survey";

export class Question {
  id: number;
  title: string;
  description: string;
  isAccessible: boolean;
  survey: Survey;
  createdAt: Date;
  updatedAt: Date;
}
