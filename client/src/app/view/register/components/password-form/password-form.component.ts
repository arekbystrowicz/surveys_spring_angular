import { Component, Input, OnInit } from '@angular/core';

import { User } from "../../../../model/user";


@Component({
  selector: 'app-password-form',
  templateUrl: './password-form.component.html',
  styleUrls: ['./password-form.component.css']
})
export class PasswordFormComponent implements OnInit {

  @Input() user: User;
  confirmedPassword: string;
  isValid: boolean;

  constructor() { }

  ngOnInit() {
  }

  public validate(): void {
    if (this.isFinished()) {
      if (this.isConfirmed()) {
        this.isValid = true;
      }
      else {
        this.isValid = false;
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
