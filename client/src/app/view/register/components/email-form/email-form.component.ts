import { Component, Input, OnInit } from '@angular/core';

import { RegisterForm } from "../../logic/register_form";

import { User } from "../../../../model/user";

import { UserService } from "../../../../service/user/user.service";


@Component({
  selector: 'app-email-form',
  templateUrl: './email-form.component.html',
  styleUrls: ['./email-form.component.css']
})
export class EmailFormComponent implements OnInit {

  @Input() form: RegisterForm;
  @Input() user: User;

  errMsg: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  public validate(): void {
    if (this.isFinished()) {
      if (!this.isValidEmail()) {
        this.errMsg = "is not a valid email!";
      } else if (!this.isUnique()) {
        this.errMsg = "email already used!";
      }
    }
  }

  private isFinished(): boolean {
    return this.form.hasEmailChanged();
  }

  private isValidEmail(): boolean {
    return this.form.validateEmail();
  }

  private isUnique(): boolean {
    return this.form.isEmailUnique();
  }

}

