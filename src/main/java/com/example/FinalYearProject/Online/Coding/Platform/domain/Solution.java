package com.example.FinalYearProject.Online.Coding.Platform.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Solution {
    @Id
    int problemId;
    String solution;

    @OneToOne
    Problems problemObj;

    public void setProblemId(int problemId) {
        this.problemId = problemId;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public void setProblemObj(Problems problemObj) {
        this.problemObj = problemObj;
    }

    public int getProblemId() {
        return problemId;
    }

    public String getSolution() {
        return solution;
    }

    public Problems getProblemObj() {
        return problemObj;
    }
    protected  Solution(){}

    public Solution(int problemId, String solution, Problems problemObj) {
        this.problemId = problemId;
        this.solution = solution;
        this.problemObj = problemObj;
    }
}
