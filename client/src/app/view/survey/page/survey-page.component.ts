import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { SurveyService } from "../../../service/survey.service";


@Component({
  selector: 'app-survey-page',
  templateUrl: './survey-page.component.html',
  styleUrls: ['./survey-page.component.css']
})
export class SurveyPageComponent implements OnInit {

  constructor(private surveyService: SurveyService, private route: ActivatedRoute) { }

  ngOnInit() {
  }

}
