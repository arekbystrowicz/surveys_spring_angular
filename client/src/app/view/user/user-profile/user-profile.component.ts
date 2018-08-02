import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { User } from "../../../model/user";
import { UserService } from "../../../service/user/user.service";


@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  private user: User;

  constructor(private userService: UserService, private route: ActivatedRoute,) { }

  ngOnInit() {
    this.get();
  }

  private get() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.userService.get(id)
      .subscribe(user => this.user = user);
  }

}
