package com.example.FinalYearProject.Online.Coding.Platform.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(ProblemTestCaseId.class)
public class ProblemDetails implements Serializable  {
    @Id
    private int problemId;
    @Id
    private int testCaseId;
    private String input;
    private String expectedOutput;

    @ManyToOne
    @JoinColumn(name="problemId",insertable = false,updatable = false)
    Problems problemObj;

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public void setTestCaseId(int testCaseId) {
        this.testCaseId = testCaseId;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

    public void setProblemObj(Problems problemObj) {
        this.problemObj = problemObj;
    }

    public int getProblemId() {
        return problemId;
    }

    public int getTestCaseId() {
        return testCaseId;
    }

    public String getInput() {
        return input;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public Problems getProblemObj() {
        return problemObj;
    }

    public ProblemDetails() {
    }

    public ProblemDetails(int problemId, int testCaseId, String input, String expectedOutput, Problems problemObj) {
        this.problemId = problemId;
        this.testCaseId = testCaseId;
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.problemObj = problemObj;
    }
}
