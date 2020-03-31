package com.example.FinalYearProject.Online.Coding.Platform.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(AttemptsId.class)
@Table(name="Attempts")
public class Attempts implements Serializable {
            @Id
          String username;
    @Id
            int problemId;
    @Column
    int numberOfAttempts;
    @ManyToOne
            @JoinColumn(name="username",insertable = false,updatable = false)
    User userObj;

    @ManyToOne
    @JoinColumn(name="problemId",insertable = false,updatable = false)
    Problems problemsObj;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }



    public void setUserObj(User userObj) {
        this.userObj = userObj;
    }

    public void setProblemsObj(Problems problemsObj) {
        this.problemsObj = problemsObj;
    }

    public String getUsername() {
        return username;
    }

    public int getProblemId() {
        return problemId;
    }



    public User getUserObj() {
        return userObj;
    }

    public Attempts(String username) {
        this.username = username;
    }
    public Attempts(String username, int problemId, int numberOfAttempts, User userObj, Problems problemsObj) {
        this.username = username;
        this.problemId = problemId;
        this.numberOfAttempts = numberOfAttempts;
        this.userObj = userObj;
        this.problemsObj = problemsObj;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public Problems getProblemsObj() {
        return problemsObj;
    }

    public Attempts() {
    }


}
