import { Component, Input, OnInit } from '@angular/core';

import { RegisterForm } from "../../logic/register_form";

import { User } from "../../../../model/user";


@Component({
  selector: 'app-email-form',
  templateUrl: './email-form.component.html',
  styleUrls: ['./email-form.component.css']
})
export class EmailFormComponent implements OnInit {

  @Input() form: RegisterForm;
  @Input() user: User;

  errMsg: string;

  constructor() { }

  ngOnInit() {
  }

  public check(): void {
    if (this.form.hasEmailChanged()) {
      if (!this.form.validateEmail()) {
        this.errMsg = "is not a valid email";
        this.form.setIsEmailValid(false);
      } else {
        this.form.geUserByEmail()
          .subscribe(response => {
            if (!!response) {
              this.errMsg = "email is already used";
              this.form.setIsEmailValid(false);
            } else {
              this.errMsg = null;
              this.form.setIsEmailValid(true);
            }
          });
      }
    } else {
      this.form.setIsEmailValid(false);
    }
  }

}

