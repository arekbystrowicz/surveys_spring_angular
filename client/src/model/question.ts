import { Survey } from "./survey";

export class Question {
  id: number;
  title: string;
  description: string;
  isPublished: boolean;
  isAccessible: boolean;
  survey: Survey;
  publishDate: Date;
  createdAt: Date;
  updatedAt: Date;
}
