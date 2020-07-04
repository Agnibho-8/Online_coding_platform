package com.example.FinalYearProject.Online.Coding.Platform.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class UserDetails {
    @Id
    String username;
    int levelsCleared;
    int totalPoints;
    String assessment;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLevelsCleared(int levelsCleared) {
        this.levelsCleared = levelsCleared;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }


    public String getUsername() {
        return username;
    }

    public int getLevelsCleared() {
        return levelsCleared;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public String getAssessment() {
        return assessment;
    }


    public UserDetails() {
    }

    public UserDetails(String username, int levelsCleared, int totalPoints, String assessment) {
        this.username = username;
        this.levelsCleared = levelsCleared;
        this.totalPoints = totalPoints;
        this.assessment = assessment;
    }
}
