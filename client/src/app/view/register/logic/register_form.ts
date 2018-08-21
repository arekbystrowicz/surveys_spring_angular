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

  public getUserByLogin(): Observable<User> {
    return this.userService.getByLogin(this.user.login);
  }

  public hasEmailChanged(): boolean {
    return !!this.user.email;
  }

  public geUserByEmail(): Observable<User> {
    return this.userService.getByEmail(this.user.email);
  }

  public isEmailValid(): boolean {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(this.user.email)) {
      return true;
    }
    return false;
  }

  public hasPasswordChanged() {
    return !!this.user.password && !!this.confirmedPassword;
  }

  public isPasswordMatched() {
    return this.user.password === this.confirmedPassword;
  }

}
