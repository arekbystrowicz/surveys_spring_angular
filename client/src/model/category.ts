import { User } from "./user";

export class Category {
  id: number;
  tag: string;
  author: User;
  createdAt: Date;
  updatedAt: Date;
}
