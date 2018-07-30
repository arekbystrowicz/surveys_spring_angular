import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { User } from "../../model/user";

@Injectable()
export class UserService {

  constructor(private http: HttpClient) { }

  public get(id: number) {

  }

  public getAll() {

  }

  public create(user: User) {

  }

  public update(user: User) {

  }

  public delete(user: User) {

  }

  public restore(user: User) {

  }

}
