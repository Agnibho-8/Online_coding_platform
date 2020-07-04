package com.example.FinalYearProject.Online.Coding.Platform.domain;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;
@Embeddable
public class UserProblemID implements Serializable {
   private String username;
   private int problemId;

    public UserProblemID() {
    }

    public String getUsername() {
        return username;
    }

    public int getProblemId() {
        return problemId;
    }

    public UserProblemID(String username, int problemId) {
        this.username = username;
        this.problemId = problemId;
    }
}
