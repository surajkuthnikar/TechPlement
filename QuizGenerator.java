import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class QuizGenerator {
    private Map<String, List<Question>> quizzes;

    public QuizGenerator() {
        this.quizzes = new HashMap<>();
    }

    public void createQuiz(String topic) {
        quizzes.put(topic, new ArrayList<>());
        System.out.println("Quiz on '" + topic + "' created successfully.");
    }

    public void addQuestion(String topic, Question question) {
        if (quizzes.containsKey(topic)) {
            quizzes.get(topic).add(question);
            System.out.println("Question added successfully to the quiz on '" + topic + "'.");
        } else {
            System.out.println("Quiz on '" + topic + "' does not exist.");
        }
    }

    public void takeQuiz(String topic) {
        if (quizzes.containsKey(topic)) {
            List<Question> quiz = quizzes.get(topic);
            Scanner scanner = new Scanner(System.in);
            int score = 0;

            System.out.println("----- " + topic + " Quiz -----");
            for (int i = 0; i < quiz.size(); i++) {
                Question question = quiz.get(i);
                System.out.println((i + 1) + ". " + question.getQuestion());
                List<String> options = question.getOptions();
                for (int j = 0; j < options.size(); j++) {
                    System.out.println((char) ('A' + j) + ") " + options.get(j));
                }
                System.out.print("Your answer: ");
                char answer = scanner.nextLine().toUpperCase().charAt(0);
                if (answer == question.getCorrectAnswer()) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect! The correct answer is " + question.getCorrectAnswer());
                }
                System.out.println();
            }
            System.out.println("----- Quiz Completed -----");
            System.out.println("Your score: " + score + "/" + quiz.size());
        } else {
            System.out.println("Quiz on '" + topic + "' does not exist.");
        }
    }
}
