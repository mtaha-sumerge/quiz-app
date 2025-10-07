package model;

import java.util.List;

public class Question {
    private final String text;
    private final List<String> possibleAnswers;
    private final int correctAnswerIndex;

    public Question(String text, List<String> possibleAnswers, int correctAnswerIndex) {
        this.text = text;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getText() {
        return text;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void displayQuestion() {
        System.out.println(this.text);
        for (String answer : possibleAnswers) {
            System.out.println(answer);
        }
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public boolean isCorrect(int answerIndex) {
        return this.correctAnswerIndex ==  answerIndex;
    }
}
