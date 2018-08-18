package com.cafetamine.surveys.solution;

import com.cafetamine.surveys.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.cafetamine.surveys.answer.Answer;
import com.cafetamine.surveys.shared.AuditModel;


@Entity
@Table(name = "solutions")
public class Solution extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @OneToOne
    private User author;
    @NotNull
    @OneToOne
    private Answer answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

}
