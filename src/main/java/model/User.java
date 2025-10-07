package model;

import java.util.List;

public class User {

    private final String userName;
    private List<Integer> userAnswers;

    public User(String userName) {
        this.userName = userName;
    }

    public void recordAnswers(List<Integer> answers) {
        this.userAnswers = answers;
    }

    public List<Integer> getUserAnswers() {
        return this.userAnswers;
    }

    public String getUserName() {
        return this.userName;
    }

    public void clearAnswers() {
        this.userAnswers.clear();
    }
}
