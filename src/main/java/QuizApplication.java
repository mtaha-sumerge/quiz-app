import model.Question;
import model.Quiz;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizApplication {

    static List<Question> questions = List.of(
            new Question("What is the capital of Spain?", List.of("1. Paris", "2. Madrid", "3. Barcelona", "4. Lisbon"), 1),
            new Question("Which language runs on JVM?", List.of("1. C++", "2. Python", "3. JavaScript", "4. Java"), 3),
            new Question("What is 2 + 3! ?", List.of("1. 5", "2. 6", "3. 8", "4. 10"), 2),
            new Question("Hieroglyphics represent a language", List.of("1. False", "2. True"), 0)
    );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Quiz quiz = new Quiz(questions);

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("Enter your username: ");
        User user = new User(scanner.next());

        List<Integer> answers = new ArrayList<>();
        System.out.println("Quiz started!");
        for (Question question : questions) {
            question.displayQuestion();
            System.out.println("Enter the choice number");
            answers.add(Integer.parseInt(scanner.next()) - 1);
        }
        user.recordAnswers(answers);
        System.out.println(user.getUserAnswers());
        int score = quiz.calculateScore(answers);
        System.out.println(user.getUserName() + "! you scored " + score + " out of " + questions.size());
        user.clearAnswers();
        System.out.println(user.getUserAnswers());

    }
}
