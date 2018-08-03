import { Component, Input, OnInit } from '@angular/core';

import { User } from "../../../model/user";

@Component({
  selector: 'app-user-badge',
  templateUrl: './user-badge.component.html',
  styleUrls: ['./user-badge.component.css']
})
export class UserBadgeComponent implements OnInit {

  @Input() user: User;

  constructor() { }

  ngOnInit() {
  }

}
