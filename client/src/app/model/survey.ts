import { User } from "./user";
import { Category } from "./category";


export class Survey {
  id: number;
  title: string;
  description: string;
  isPublished: boolean;
  isAccessible: boolean;
  publishDate: Date;
  createdAt: Date;
  updatedAt: Date;
  author: User;
  categories: Category[] = [];
}
