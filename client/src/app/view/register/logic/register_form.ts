import { Injectable } from "@angular/core";

import { User } from "../../../model/user";

import { UserService } from "../../../service/user/user.service";


@Injectable()
export class RegisterForm {

  user: User = new User();

  constructor(private userService: UserService) {
  }

}
