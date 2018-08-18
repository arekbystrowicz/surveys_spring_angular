import { Component, Input, OnInit } from '@angular/core';

import { SurveyForm } from "../form/form";
import { Category } from "../../../model/category";

@Component({
  selector: 'app-new-category-form',
  templateUrl: './new-category-form.component.html',
  styleUrls: ['./new-category-form.component.css']
})
export class NewCategoryFormComponent implements OnInit {

  @Input() form: SurveyForm;
  category: Category = new Category();

  constructor() { }

  ngOnInit() {
  }

  public addCategory(): void {
    if (this.category.tag) {
      this.form.addCategory(this.category);
      this.category = new Category();
    }
  }

}
