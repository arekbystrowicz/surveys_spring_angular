import { Component, Input, OnInit } from '@angular/core';

import { RegisterForm } from "../../logic/register_form";

import { User } from "../../../../model/user";

import { UserService } from "../../../../service/user/user.service";


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  @Input() user: User;
  @Input() form: RegisterForm;

  errMsg: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  public check(): void {
    if (this.form.hasLoginChanged()) {
      this.form.getUserByLogin()
        .subscribe(response => {
          if (!!response) {
            this.errMsg = "username is already used";
          } else {
            this.errMsg ="";
          }
        })
    }
  }

}
