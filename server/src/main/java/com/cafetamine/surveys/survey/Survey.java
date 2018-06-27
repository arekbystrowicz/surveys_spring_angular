package com.cafetamine.surveys.survey;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;


@Entity
public class Survey {

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
    private Date publishDate;
    @NotNull
    private Boolean isPublished;
    @NotNull
    private Boolean isAccessible;

}
