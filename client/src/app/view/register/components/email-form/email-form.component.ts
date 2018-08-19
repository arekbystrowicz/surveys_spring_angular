import { Component, Input, OnInit } from '@angular/core';

import { User } from "../../../../model/user";


@Component({
  selector: 'app-email-form',
  templateUrl: './email-form.component.html',
  styleUrls: ['./email-form.component.css']
})
export class EmailFormComponent implements OnInit {

  @Input() user: User;
  @Input() emailIsValid: boolean;

  constructor() { }

  ngOnInit() {
  }

}
