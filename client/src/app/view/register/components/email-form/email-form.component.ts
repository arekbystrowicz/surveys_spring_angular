import { Component, Input, OnInit } from '@angular/core';

import { User } from "../../../../model/user";

import { UserService } from "../../../../service/user/user.service";


@Component({
  selector: 'app-email-form',
  templateUrl: './email-form.component.html',
  styleUrls: ['./email-form.component.css']
})
export class EmailFormComponent implements OnInit {

  @Input() user: User;
  @Input() emailIsValid: boolean;

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
    if (this.user.email) {
      return true;
    }
    return false;
  }

  private isValidEmail(): boolean {
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(this.user.email)) {
      return true;
    }
    return false;
  }

  private isUnique(): void {
    this.userService.getByEmail(this.user.email)
      .subscribe(
        response => this.handleUsedEmail(),
        err => this.handleValidEmail()
      );
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

