import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { SurveyService } from "../../service/survey/survey.service";


@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  constructor(private surveyService: SurveyService, private route: ActivatedRoute) { }

  ngOnInit() {
  }

}
