import {Component, Input, OnInit} from '@angular/core';

import { User } from "../../../../model/user";


@Component({
  selector: 'app-password-form',
  templateUrl: './password-form.component.html',
  styleUrls: ['./password-form.component.css']
})
export class PasswordFormComponent implements OnInit {

  @Input() user: User;
  confirmedPassword: string;

  constructor() { }

  ngOnInit() {
  }

}
