import { Component, Input, OnInit } from '@angular/core';

import { RegisterForm } from "../../logic/register_form";

import { User } from "../../../../model/user";


@Component({
  selector: 'app-password-form',
  templateUrl: './password-form.component.html',
  styleUrls: ['./password-form.component.css']
})
export class PasswordFormComponent implements OnInit {

  @Input() user: User;
  @Input() form: RegisterForm;

  errMsg: string;

  constructor() { }

  ngOnInit() {
  }

  public check(): void {
    if (this.form.hasPasswordChanged()) {
      if (this.form.isPasswordMatched()) {
        this.errMsg = null;
      } else {
        this.errMsg = "password confirmation doesn't match";
      }
    }
  }

}
