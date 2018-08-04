import { Deserializable } from "./deserializable";
import { User } from "./user";
import { Category } from "./category";


export class Survey implements Deserializable<Survey> {
  id: number;
  title: string;
  description: string;
  isPublished: boolean;
  isAccessible: boolean;
  publishDate: Date;
  createdAt: Date;
  updatedAt: Date;
  author: User;
  categories: Category[];

  public deserialize(object: any): Survey {
    this.id = object.id;
    this.title = object.title;
    this.description = object.description;
    this.isPublished = object.isPublished;
    this.isAccessible = object.isAccessible;
    this.publishDate = object.publishDate;
    this.createdAt = object.createdAt;
    this.updatedAt = object.updatedAt;
    this.author = new User().deserialize(object.author);

    for (let category of object.categories) {
      this.categories.push(new Category().deserialize(category));
    }

    return this;
  }

}
