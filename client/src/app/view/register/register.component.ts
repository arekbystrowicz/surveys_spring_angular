import { Component, OnInit } from '@angular/core';

import { User } from "../../model/user";

import { RegisterForm } from "./logic/register_form";


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user: User = new User();

  constructor(private form: RegisterForm) {
  }

  ngOnInit() {
  }

  public register(): void {

  }

}
