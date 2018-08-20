import { Component, OnInit } from '@angular/core';

import { User } from "../../model/user";

import { UserService } from "../../service/user/user.service";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  passwordIsValid: boolean;
  loginIsValid: boolean;
  emailIsValid: boolean;

  constructor(private userService: UserService) {
    this.userService = userService;
  }

  ngOnInit() {
  }

  public register(): void {
    if (this.isValid()) {
      this.userService.create(this.user)
        .subscribe(response => this.user = this.user);
    }
  }

  public isValid(): boolean {
    return this.passwordIsValid && this.loginIsValid && this.emailIsValid;
  }

}
