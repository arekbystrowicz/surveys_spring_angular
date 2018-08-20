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

  public validate(): void {
    if (this.isFinished()) {
      if (!this.isValid()) {
        this.errMsg = "username is already used!"
      }
    }
  }

  public isFinished(): boolean {
    return this.form.hasLoginChanged();
  }

  public isValid(): boolean {
    return this.form.isLoginUnique();
  }

}
