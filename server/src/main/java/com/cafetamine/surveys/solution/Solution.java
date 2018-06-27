package com.cafetamine.surveys.solution;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import com.cafetamine.surveys.answer.Answer;
import com.cafetamine.surveys.user.User;



@Entity
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private User author;
    @NotNull
    private Answer answer;

}
