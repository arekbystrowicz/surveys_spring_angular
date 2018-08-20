import { Component, Input, OnInit } from '@angular/core';

import { RegisterForm } from "../../logic/register_form";

import { UserService } from "../../../../service/user/user.service";


@Component({
  selector: 'app-email-form',
  templateUrl: './email-form.component.html',
  styleUrls: ['./email-form.component.css']
})
export class EmailFormComponent implements OnInit {

  @Input() form: RegisterForm;

  errMsg: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  public validate(): void {
    if (this.isFinished()) {
      if (this.isValidEmail()) {
        this.isUnique();
      } else {
        this.handleInvalidEmail();
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

  private handleInvalidEmail(): void {
    this.errMsg = "is not a valid email";
    this.emailIsValid = false;
  }

  private handleUsedEmail(): void {
    this.errMsg = "email is already used";
    this.emailIsValid = false;
  }

  private handleValidEmail(): void {
    this.errMsg = null;
    this.emailIsValid = true;
  }

}

