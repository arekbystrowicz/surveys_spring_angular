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

  constructor() { }

  ngOnInit() {
  }

  public validate(): void {
    if (this.isFinished()) {
      if (this.isConfirmed()) {
        this.passwordIsValid = true;
      }
      else {
        this.passwordIsValid = false;
      }
    }
  }

  private isFinished(): boolean {
    if (this.user.password && this.confirmedPassword) {
      return true;
    }
    return false;
  }

  private isConfirmed(): boolean {
    return this.user.password === this.confirmedPassword;
  }

}
