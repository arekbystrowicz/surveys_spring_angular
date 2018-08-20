import { Component, Input, OnInit } from '@angular/core';

import { User } from "../../../../model/user";


@Component({
  selector: 'app-password-form',
  templateUrl: './password-form.component.html',
  styleUrls: ['./password-form.component.css']
})
export class PasswordFormComponent implements OnInit {

  @Input() user: User;
  @Input() passwordIsValid: boolean;
  confirmedPassword: string;
  errMsg: string;

  constructor() { }

  ngOnInit() {
  }

  public validate(): void {
    if (this.isFinished()) {
      if (this.isConfirmed()) {
        this.errMsg = null;
        this.passwordIsValid = true;
      }
      else {
        this.errMsg = "passwords doesn't match";
        this.passwordIsValid = false;
      }
    }
  }

  private isFinished(): boolean {
    if (this.user.password && this.confirmedPassword) {
      return true;
    }
    this.errMsg = null;
    return false;
  }

  private isConfirmed(): boolean {
    return this.user.password === this.confirmedPassword;
  }

}
