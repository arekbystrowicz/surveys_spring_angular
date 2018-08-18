import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";

import { SurveyForm } from "./logic/form";


@Component({
  selector: 'app-editor',
  templateUrl: './editor.component.html',
  styleUrls: ['./editor.component.css']
})
export class EditorComponent implements OnInit {

  constructor(private form: SurveyForm,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.form.init(+this.route.snapshot.paramMap.get('id'));
  }

}
