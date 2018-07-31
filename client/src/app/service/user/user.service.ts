import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { User } from "../../model/user";


@Injectable()
export class UserService {

  private originUrl = '//localhost:8080/users';

  constructor(private http: HttpClient) { }

  public get(id: number): Observable<User> {
    return this.http.get<User>(`${this.originUrl}/${id}`);
  }

  public getAll(): Observable<User[]> {
    return null;
  }

  public create(user: User): Observable<User> {
    return null;
  }

  public update(user: User): Observable<User> {
    return null;
  }

  public delete(user: User):  Observable<User> {
    return null;
  }

  public restore(user: User): Observable<User> {
    return null;
  }

}
