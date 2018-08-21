import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';

import { User } from "../../model/user";

import { RegisterForm } from "./logic/register_form";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private form: RegisterForm, private location: Location) {
  }

  ngOnInit() {
  }

  public register(): void {
    if (this.form.isValid()) {
      this.form.register()
        .subscribe(response => {
          location.assign(`users/${response.id}`);
        });
    }
  }

}
