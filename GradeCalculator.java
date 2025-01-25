import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        // Create a Scanner object for input
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        // Declare an array to store the marks
        int[] marks = new int[numSubjects];
        int totalMarks = 0;
        
        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i];  // Sum up the marks
        }
        
        // Calculate the average percentage
        double averagePercentage = (double) totalMarks / numSubjects;
        
        // Determine the grade
        String grade = getGrade(averagePercentage);
        
        // Display the results
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        // Close the scanner
        scanner.close();
    }

    // Method to determine the grade based on average percentage
    public static String getGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B+";
        } else if (averagePercentage >= 60) {
            return "B";
        } else if (averagePercentage >= 50) {
            return "C+";
        } else if (averagePercentage >= 40) {
            return "C";
        } else {
            return "F";
        }
    }
}
