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
    String sampleInput;
    String sampleOutput;

    public int getProblemId() {
        return problemId;
    }

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getPointsAlotted() {
        return pointsAlotted;
    }

    public void setPointsAlotted(int pointsAlotted) {
        this.pointsAlotted = pointsAlotted;
    }

    public String getSampleInput() {
        return sampleInput;
    }

    public void setSampleInput(String sampleInput) {
        this.sampleInput = sampleInput;
    }

    public String getSampleOutput() {
        return sampleOutput;
    }

    public void setSampleOutput(String sampleOutput) {
        this.sampleOutput = sampleOutput;
    }

    public Problems() {
    }

    public Problems(int problemId, String problemStatement, String difficultyLevel, int pointsAlotted, String sampleInput, String sampleOutput) {
        this.problemId = problemId;
        this.problemStatement = problemStatement;
        this.difficultyLevel = difficultyLevel;
        this.pointsAlotted = pointsAlotted;
        this.sampleInput = sampleInput;
        this.sampleOutput = sampleOutput;
    }
}
