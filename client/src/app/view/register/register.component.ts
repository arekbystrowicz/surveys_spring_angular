import { Component, OnInit } from '@angular/core';

import { User } from "../../model/user";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();
  confirmedPassword: string;

  constructor() { }

  ngOnInit() {
  }

  public validate(): void {
    let isValid: boolean = true;
    if (!this.isPasswordConfirmed()) {
      isValid = false;
    }
    console.log(isValid);
  }

  private isPasswordConfirmed(): boolean {
    return this.user.password && this.user.password === this.confirmedPassword;
  }

}
