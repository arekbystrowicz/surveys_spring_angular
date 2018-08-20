import { Component, Input, OnInit } from '@angular/core';

import { RegisterForm } from "../../logic/register_form";

import { UserService } from "../../../../service/user/user.service";


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  @Input() form: RegisterForm;

  errMsg: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  public validate(): void {
    if (this.isFinished()) {
      this.isUnique();
    }
  }

  private isFinished(): boolean {
    return this.form.hasUserLoginChanged();
  }

  private isUnique(): void {
    this.userService.getByLogin(this.user.login)
      .subscribe(
        response => this.handleUsedLogin(),
        err => this.handleValidLogin()
      );
  }

  private handleUsedLogin(): void {
    this.errMsg = "login is already used";
    this.loginIsValid = false;
  }

  private handleValidLogin(): void {
    this.errMsg = null;
    this.loginIsValid = true;
  }

}
