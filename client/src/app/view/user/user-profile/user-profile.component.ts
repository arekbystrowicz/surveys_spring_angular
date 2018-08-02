import { Component, OnInit } from '@angular/core';

import { UserService } from "../../../service/user/user.service";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

}
