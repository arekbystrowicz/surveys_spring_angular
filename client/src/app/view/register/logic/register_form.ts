import { Injectable } from "@angular/core";

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
    return this.user.login !== "";
  }

  public isLoginUnique(): boolean {
    let user: User;
    return !!this.userService.getByLogin(this.user.login)
      .subscribe(
        response => user = response,
        err => user = null
      );
  }

  public hasEmailChanged(): boolean {
    return this.user.email !== "";
  }

  public hasPasswordChanged(): boolean {
    return this.user.password !== "" && this.confirmedPassword !== "";
  }

  public register(): void {
    this.userService.create(this.user)
      .subscribe(response => this.user = response);
  }

  public isValid(): boolean {
    return true;
    // return this.passwordIsValid && this.loginIsValid && this.emailIsValid;
  }

}
