package com.example.FinalYearProject.Online.Coding.Platform.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SolvedProblemsByUser {
    @EmbeddedId
    private UserProblemID userProblemID;
    private boolean isSolved;

    public SolvedProblemsByUser() {
    }

    public SolvedProblemsByUser(UserProblemID userProblemID, boolean isSolved) {
        this.userProblemID = userProblemID;
        this.isSolved = isSolved;
    }

    public UserProblemID getUserProblemID() {
        return userProblemID;
    }

    public boolean isSolved() {
        return isSolved;
    }
}
