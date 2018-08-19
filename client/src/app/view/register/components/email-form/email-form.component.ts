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

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  public validate() {
    if (this.isFinished()) {
      this.isUnique();
    }
  }

  public isFinished() {
    return true;
  }

  public isUnique() {
    return true;
  }

}
