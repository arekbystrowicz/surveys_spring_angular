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

}
