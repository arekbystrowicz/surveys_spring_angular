import { Injectable } from "@angular/core";

import { User } from "../../../model/user";

import { UserService } from "../../../service/user/user.service";


@Injectable()
export class RegisterForm {

  user: User = new User();

  constructor(private userService: UserService) {
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
