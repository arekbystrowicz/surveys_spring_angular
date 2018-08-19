import { Component, Input, OnInit } from '@angular/core';

import { User } from "../../../model/user";


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  @Input() user: User;
  @Input() loginIsValid: boolean;

  constructor() { }

  ngOnInit() {
  }

}
