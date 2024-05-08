import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuizGenerator quizGenerator = new QuizGenerator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Quiz\n2. Add Question\n3. Take Quiz\n4. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the topic of the quiz: ");
                    String topic = scanner.nextLine();
                    quizGenerator.createQuiz(topic);
                    break;
                case 2:
                    System.out.print("Enter the topic of the quiz: ");
                    String quizTopic = scanner.nextLine();
                    System.out.print("Enter the question: ");
                    String question = scanner.nextLine();
                    System.out.print("Enter the number of options: ");
                    int numOptions = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    List<String> options = new ArrayList<>();
                    for (int i = 0; i < numOptions; i++) {
                        System.out.print("Enter option " + (char) ('A' + i) + ": ");
                        options.add(scanner.nextLine());
                    }
                    System.out.print("Enter the correct answer (A/B/C/D): ");
                    char correctAnswer = scanner.nextLine().toUpperCase().charAt(0);

                    quizGenerator.addQuestion(quizTopic, new Question(question, options, correctAnswer));
                    break;
                case 3:
                    System.out.print("Enter the topic of the quiz you want to take: ");
                    String quizToTake = scanner.nextLine();
                    quizGenerator.takeQuiz(quizToTake);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
