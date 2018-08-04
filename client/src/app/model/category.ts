import { Deserializable } from "./deserializable";
import { User } from "./user";


export class Category implements Deserializable<Category> {
  id: number;
  tag: string;
  author: User;
  createdAt: Date;
  updatedAt: Date;

  public deserialize(object: any): Category {
    this.id = object.id;
    this.tag = object.tag;
    this.createdAt = object.createdAt;
    this.updatedAt = object.updatedAt;
    this.author = new User().deserialize(object.author);

    return this;
  }

}
