package com.cafetamine.surveys.answer;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;


@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String description;
    @NotNull
    private Date creationDate;
    private Date lastUpdateDate;

}
