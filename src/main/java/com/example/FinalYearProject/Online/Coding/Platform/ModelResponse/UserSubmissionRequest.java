package com.example.FinalYearProject.Online.Coding.Platform.ModelResponse;

public class UserSubmissionRequest {
    String language;
    String answer;

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "UserSubmissionRequest{" +
                "language='" + language + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
    public UserSubmissionRequest() {
    }

    public UserSubmissionRequest(String language, String answer) {
        this.language = language;
        this.answer = answer;
    }
}
