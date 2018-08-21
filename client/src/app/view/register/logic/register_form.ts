import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";

import { User } from "../../../model/user";

import { UserService } from "../../../service/user/user.service";


@Injectable()
export class RegisterForm {

  user: User = new User();
  confirmedPassword: string;

  constructor(private userService: UserService) {
  }

  public getUser(): User {
    return this.user;
  }

  public hasLoginChanged(): boolean {
    return !!this.user.login;
  }

  public getUserByLogin() {
    return this.userService.getByLogin(this.user.login);
  }

}
