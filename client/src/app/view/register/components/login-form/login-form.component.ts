import { Component, Input, OnInit } from '@angular/core';

import { User } from "../../../../model/user";

import { UserService } from "../../../../service/user/user.service";


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  @Input() user: User;
  @Input() loginIsValid: boolean;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  public validate(): void {
    if (this.isFinished()) {
      this.isUnique();
    }
  }

  private isFinished(): boolean {
    return this.user.login !== "";
  }

  private isUnique(): void {
    this.userService.getByLogin(this.user.login)
      .subscribe(user => {
        if (user) {
          this.loginIsValid = true;
        } else {
          this.loginIsValid = false;
        }
      });
  }

}
