import { Injectable } from "@angular/core";

import { UserService } from "../../../service/user/user.service";


@Injectable()
export class RegisterForm {

  constructor(private userService: UserService) {
  }

}
