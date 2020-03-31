package com.example.FinalYearProject.Online.Coding.Platform.domain;

import javax.persistence.*;

@Entity
public class Problems {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    int problemId;
    String problemStatement;
    String difficultyLevel;
    int pointsAlotted;

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }


    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setPointsAlotted(int pointsAlotted) {
        this.pointsAlotted = pointsAlotted;
    }

    public int getProblemId() {
        return problemId;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public int getPointsAlotted() {
        return pointsAlotted;
    }
    protected Problems(){}

    public Problems( String problemStatement, String difficultyLevel, int pointsAlotted) {
        this.problemStatement = problemStatement;
        this.difficultyLevel = difficultyLevel;
        this.pointsAlotted = pointsAlotted;
    }
}
