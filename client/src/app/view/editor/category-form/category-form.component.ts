import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../form/form";
import { Category } from "../../../model/category";


@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {

  @Input() category: Category;
  @Input() form: SurveyForm;

  constructor() { }

  ngOnInit() {
  }

  public remove(): void {
    this.form.removeCategory(this.category);
  }

}
