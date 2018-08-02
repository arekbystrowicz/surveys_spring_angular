import { Component, OnInit } from '@angular/core';

import { User } from "../../../model/user";
import { UserService } from "../../../service/user/user.service";


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  private user: User;

  constructor(private userService: UserService) { }

  private get() {
    let temporaryIdSolution = 1;
    this.userService.get(temporaryIdSolution)
      .subscribe(user => this.user = user);

  }

  ngOnInit() {
    this.get();
  }

}
