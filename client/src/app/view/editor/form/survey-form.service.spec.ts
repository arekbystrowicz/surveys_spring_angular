import { TestBed, inject } from '@angular/core/testing';

import { SurveyFormService } from './survey-form.service';

describe('SurveyFormService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SurveyFormService]
    });
  });

  it('should be created', inject([SurveyFormService], (service: SurveyFormService) => {
    expect(service).toBeTruthy();
  }));
});
