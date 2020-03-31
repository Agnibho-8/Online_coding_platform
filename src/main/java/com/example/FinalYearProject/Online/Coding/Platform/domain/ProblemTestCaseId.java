package com.example.FinalYearProject.Online.Coding.Platform.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

public class ProblemTestCaseId implements Serializable {
    private int problemId;
    private int testCaseId;

   public  ProblemTestCaseId()
    {

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProblemTestCaseId that = (ProblemTestCaseId) o;
        return problemId == that.problemId &&
                testCaseId == that.testCaseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(problemId, testCaseId);
    }

    public ProblemTestCaseId(int problemId, int testCaseId) {
        this.problemId = problemId;
        this.testCaseId = testCaseId;
    }
}
