package com.cafetamine.surveys.user;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.Date;


public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String login;
    @NotEmpty
    private String email;
    @NotEmpty
    private String password;
    @NotEmpty
    private  String name;
    @NotEmpty
    private String surname;
    @NotNull
    private Date joinDate;
    private Date lastUpdateDate;
    @NotNull
    private Boolean isActive;

}
