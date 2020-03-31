package com.example.FinalYearProject.Online.Coding.Platform.domain;

import java.io.Serializable;
import java.util.Objects;

public class AttemptsId implements Serializable {
    private String username;
    private int problemId;

    @Override
    public String toString() {
        return "AttemptsId{" +
                "username='" + username + '\'' +
                ", problemId=" + problemId +
                '}';
    }
    public AttemptsId()
    {

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttemptsId that = (AttemptsId) o;
        return problemId == that.problemId &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, problemId);
    }

    public AttemptsId(String username, int problemId) {
        this.username = username;
        this.problemId = problemId;
    }
}
