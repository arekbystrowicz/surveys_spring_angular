import { Component, OnInit } from '@angular/core';

import { User } from "../../model/user";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  passwordIsValid: boolean = false;
  loginIsValid: boolean = false;
  emailIsValid: boolean = false;

  constructor() { }

  ngOnInit() {
  }

  public register(): void {
    if (this.isValid()) {

    }
  }

  public isValid(): boolean {
    return this.passwordIsValid && this.loginIsValid && this.emailIsValid;
  }

}
