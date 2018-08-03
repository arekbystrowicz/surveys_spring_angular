import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";

import { UserService } from "../../../service/user/user.service";
import { User } from "../../../model/user";


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(private http: HttpClient, private userService: UserService, private router: Router) { }

  ngOnInit() {
    this.getAll();
  }

  private getAll(): void {
    this.userService.getAll().subscribe(users => {
      this.users = users;
    });
  }

  public redirectToProfile(user: User): void {
    this.router.navigate([`/users/${user.id}`]);
  }

}
