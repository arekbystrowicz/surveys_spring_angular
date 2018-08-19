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

  errMsg: string = "email is already used!";

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  public validate(): void {
    if (this.isFinished()) {
      this.isUnique();
    }
  }

  private isFinished(): boolean {
    if (this.user.email) {
      return true;
    }
    return false;
  }

  private isUnique(): void {
    this.userService.getByEmail(this.user.email)
      .subscribe(user => {
        if (user) {
          this.errMsg = "email is already used!";
          this.emailIsValid = false;
        } else {
          this.emailIsValid = true;
        }
      });
  }

}
