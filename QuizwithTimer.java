import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizwithTimer {
    private static int score = 0;
    private static int currentQuestionIndex = 0;
    private static boolean[] userAnswers;
    private static Question[] questions;

    public static void main(String[] args) {
        initializeQuiz();
        startQuiz();
    }

    private static void initializeQuiz() {
        // Initialize quiz questions and options
        questions = new Question[3];
        questions[0] = new Question("Who is the supreme god in Hinduism?", new String[]{"A. Brahma", "B. Vishnu", "C. Shiva", "D. Krishna"}, 2);
        questions[1] = new Question("What is the cycle of birth, death, and rebirth called in Hinduism?", new String[]{"A. Dharma", "B. Karma", "C. Samsara", "D. Moksha"}, 2);
        questions[2] = new Question("What river is considered sacred in Hinduism?", new String[]{"A. Ganges", "B. Yamuna", "C. Sarasvati", "D. Indus"}, 0);

        // Initialize userAnswers array to keep track of user's answers
        userAnswers = new boolean[questions.length];
    }

    private static void startQuiz() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Quiz Application!");

            for (currentQuestionIndex = 0; currentQuestionIndex < questions.length; currentQuestionIndex++) {
                Question currentQuestion = questions[currentQuestionIndex];

                System.out.println("\nQuestion " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());

                for (String option : currentQuestion.getOptions()) {
                    System.out.println(option);
                }

                System.out.print("Your answer (enter A, B, C, or D): ");

                // Set a timer for each question
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("\nTime's up! Moving to the next question.");
                        evaluateAnswer("", currentQuestion);
                    }
                }, 15000); // 15 seconds

                String userAnswer = scanner.nextLine().toUpperCase();

                // Cancel the timer when the user submits an answer
                timer.cancel();

                evaluateAnswer(userAnswer, currentQuestion);
            }
        }

        // Display final score and summary
        System.out.println("\nQuiz Completed!");
        System.out.println("Your Final Score: " + score + "/" + questions.length);

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " +
                    (userAnswers[i] ? "Correct" : "Incorrect"));
        }
    }

    private static void evaluateAnswer(String userAnswer, Question currentQuestion) {
        boolean isCorrect = userAnswer.equals(currentQuestion.getCorrectOption());
        userAnswers[currentQuestionIndex] = isCorrect;
    
        // Check if the user's answer is correct
        if (isCorrect) {
            score++;
            System.out.println("Correct!\n");
        } else {
            System.out.println("Incorrect! The correct answer is " +
                    currentQuestion.getOptions()[currentQuestion.getCorrectOptionIndex()] + "\n");
        }
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctOptionIndex;

    public Question(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }

    public String getCorrectOption() {
        return Character.toString((char) ('A' + correctOptionIndex));
    }
}
