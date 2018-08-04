import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";

import { SurveyService } from "../../../service/survey.service";


@Component({
  selector: 'app-surevy-list',
  templateUrl: './surevy-list.component.html',
  styleUrls: ['./surevy-list.component.css']
})
export class SurevyListComponent implements OnInit {

  constructor(private http: HttpClient, private surveyService: SurveyService) { }

  ngOnInit() {
  }

}
