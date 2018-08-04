import { Deserializable } from "./deserializable";

export class User implements Deserializable<User> {
  id: number;
  login: string;
  email: string;
  password: string;
  name: string;
  surname: string;
  createdAt: Date;
  updatedAt: Date;
  isActive: boolean;

  public deserialize(object: any): User {
    this.id = object.id;
    this.login = object.login;
    this.email = object.email;
    this.password = object.password;
    this.name = object.name;
    this.surname = object.surname;
    this.createdAt = object.createdAt;
    this.updatedAt = object.updatedAt;
    this.isActive = object.isActive;

    return this;
  }

}
