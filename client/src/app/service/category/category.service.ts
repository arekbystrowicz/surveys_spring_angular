import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs/Observable";

import { Category } from "../../model/category";


@Injectable()
export class CategoryService {

  private originUrl = '//localhost:8080/categories';

  constructor(private http: HttpClient) { }

  public get(id: number): Observable<Category> {
    return this.http.get<Category>(`${this.originUrl}/${id}`);
  }

  public getAll(): Observable<Category[]> {
    return this.http.get<Category[]>(this.originUrl);
  }

  public create(category: Category): Observable<Category> {
    return this.http.post<Category>(this.originUrl, category);
  }

}
