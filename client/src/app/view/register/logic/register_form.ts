import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";

import { User } from "../../../model/user";

import { UserService } from "../../../service/user/user.service";


@Injectable()
export class RegisterForm {

  public user: User = new User();
  public confirmedPassword: string;

  private isLoginValid: boolean = false;
  private isEmailValid: boolean = false;
  private isPasswordValid: boolean = false;

  constructor(private userService: UserService) {
  }

  public getUser(): User {
    return this.user;
  }

  public setIsLoginValid(isLoginValid: boolean): void {
    this.isLoginValid = isLoginValid;
  }

  public setIsEmailValid(isEmailValid: boolean): void {
    this.isEmailValid = isEmailValid;
  }

  public setIsPasswordValid(isPasswordValid: boolean): void {
    this.isPasswordValid = isPasswordValid;
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

  public validateEmail(): boolean {
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

  public isValid(): boolean {
    return this.isLoginValid && this.isEmailValid && this.isPasswordValid;
  }

  public register(): Observable<User> {
    return this.userService.create(this.user);
  }

}
