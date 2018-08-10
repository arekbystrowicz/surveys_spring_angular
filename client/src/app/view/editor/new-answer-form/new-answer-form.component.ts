import { Component, Input, OnInit } from '@angular/core';
import { SurveyForm } from "../form/form";

@Component({
  selector: 'app-new-answer-form',
  templateUrl: './new-answer-form.component.html',
  styleUrls: ['./new-answer-form.component.css']
})
export class NewAnswerFormComponent implements OnInit {

  @Input() form: SurveyForm;

  constructor() { }

  ngOnInit() {
  }

}
