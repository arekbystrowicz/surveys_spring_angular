import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Injectable()
export class CategoryService {

  private originUrl = '//localhost:8080/categories';

  constructor(private http: HttpClient) { }

}
