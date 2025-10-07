package model;

import java.util.List;

public class Quiz {

    private List<Question> questions;

    public Quiz() {}

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public boolean addQuestion(Question question) {
        return questions.add(question);
    }

    public int calculateScore(List<Integer> answers) {
        int score = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (this.questions.get(i).isCorrect(answers.get(i))) {
                score++;
            }
        }
        return score;
    }
}
