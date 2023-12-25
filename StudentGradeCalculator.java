import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Calculator");
        int numSubjects;
        do {
            System.out.print("Enter the number of subjects: ");
            numSubjects = scanner.nextInt();
        } while (numSubjects <= 0);

        int[] subjectMarks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            subjectMarks[i] = scanner.nextInt();
        }

        int totalMarks = calculateTotalMarks(subjectMarks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        char grade = calculateGrade(averagePercentage);
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static int calculateTotalMarks(int[] subjectMarks) {
        int totalMarks = 0;
        for (int marks : subjectMarks) {
            totalMarks += marks;
        }
        return totalMarks;
    }

    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else if (averagePercentage >= 50) {
            return 'E';
        } else if (averagePercentage >= 40) {
            return 'F';
        } else if (averagePercentage >= 35) {
            return 'G';
        } else {
            return 'H';
        }
    }
}
