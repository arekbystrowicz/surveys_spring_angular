import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../form/form";

@Component({
  selector: 'app-new-category-form',
  templateUrl: './new-category-form.component.html',
  styleUrls: ['./new-category-form.component.css']
})
export class NewCategoryFormComponent implements OnInit {

  @Input() form: SurveyForm;

  constructor() { }

  ngOnInit() {
  }

}
