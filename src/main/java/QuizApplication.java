import model.Question;
import model.Quiz;
import model.User;

import java.util.*;

public class QuizApplication {

    static int quizSize = 5;

    static List<Question> questions = List.of(
            new Question("What is the capital of Spain?", List.of("1. Paris", "2. Madrid", "3. Barcelona", "4. Lisbon"), 1),
            new Question("Which language runs on JVM?", List.of("1. C++", "2. Python", "3. JavaScript", "4. Java"), 3),
            new Question("What is 2 + 3! ?", List.of("1. 5", "2. 6", "3. 8", "4. 10"), 2),
            new Question("Hieroglyphics represent a language", List.of("1. False", "2. True"), 0),
            new Question("What is the largest continent in the world?", List.of("1. Africa", "2. Asia", "3. North America", "4. South America"), 1),
            new Question("Who painted the Mona Lisa?", List.of("1. Vincent van Gogh", "2. Pablo Picasso", "3. Leonardo da Vinci", "4. Michelangelo"), 2),
            new Question("What is the largest ocean on Earth?", List.of("1. Atlantic Ocean", "2. Pacific Ocean", "3. Indian Ocean", "4. Arctic Ocean"), 1),
            new Question("Which planet is known as the Red Planet?", List.of("1. Earth", "2. Venus", "3. Mars", "4. Jupiter"), 2),
            new Question("What year was Java first released in?", List.of("1. 1991", "2. 1995", "3. 1999", "4. 2001"), 1),
            new Question("Which country hosted the 2022 FIFA World Cup?", List.of("1. Brazil", "2. Russia", "3. Germany", "4. Qatar"), 3),
            new Question("What is the chemical symbol for gold?", List.of("1. Go", "2. Hg", "3. Au", "4. Ag"), 3)
            );

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz Application!");
        System.out.println("Enter your username: ");
        User user = new User(scanner.next());

        // This set to handle the occurrence of a repeated random index
        Set<Question> quizQuestions = new HashSet<>();
        Random random = new Random();

        while (quizQuestions.size() < quizSize) {
            int randomIndex = random.nextInt(questions.size());
            quizQuestions.add(questions.get(randomIndex));
        }

        Quiz quiz = new Quiz(new ArrayList<Question>(quizQuestions));

        List<Integer> answers = new ArrayList<>();
        System.out.println("Quiz started!");
        for (Question question : quizQuestions) {
            question.displayQuestion();
            System.out.println("Enter the choice number");
            answers.add(Integer.parseInt(scanner.next()) - 1);
        }
        user.recordAnswers(answers);
        int score = quiz.calculateScore(answers);
        System.out.println(user.getUserName() + "! you scored " + score + " out of " + quizSize);
        user.clearAnswers();
    }
}
