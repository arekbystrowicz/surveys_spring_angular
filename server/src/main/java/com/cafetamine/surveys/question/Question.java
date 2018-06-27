package com.cafetamine.surveys.question;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;

import com.cafetamine.surveys.survey.Survey;


@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @NotNull
    private Date creationDate;
    private Date lastUpdateDate;
    @NotNull
    private Boolean isAccessible;
    @NotNull
    @OneToOne
    private Survey survey;

}
