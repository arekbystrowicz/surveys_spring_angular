import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { UserService } from "../../../service/user/user.service";


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private http: HttpClient, private userService: UserService) { }

  ngOnInit() {
  }

}
