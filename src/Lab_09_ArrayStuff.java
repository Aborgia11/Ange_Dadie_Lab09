import java.util.Random;
import java.util.Scanner;

public class Lab_09_ArrayStuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Problem 1
        int[] dataPoints = new int[100];

        // b. Initialize each element in dataPoints to a random value between 1 and 100
        Random random = new Random();
        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = random.nextInt(100) + 1;
        }

        // c. Display the dataPoints values
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1) {
                System.out.print(" | ");
            }
        }
        System.out.println(); // Move to the next line after displaying the array

        // d. Calculate the sum and the average of the values in dataPoints
        int sum = 0;
        for (int value : dataPoints) {
            sum += value;
        }
        double average = (double) sum / dataPoints.length;

        // Output the sum and the calculated average
        System.out.printf("The sum of the random array dataPoints is: %d%n", sum);
        System.out.printf("The average of the random array dataPoints is: %.2f%n", average);

        // Problem 2
        // a. Prompt and input an int value between 1 and 100 from the user
        int userValue = SafeInput.getRangedInt(scanner, "Enter an integer between 1 and 100", 1, 100);

        // b. Code a loop that counts how many times the user's value is found within the array
        int count = 0;
        for (int value : dataPoints) {
            if (value == userValue) {
                count++;
            }
        }
        System.out.printf("The user's value (%d) was found %d times in the array.%n", userValue, count);

        // c. Prompt the user again for a value between 1 and 100
        userValue = SafeInput.getRangedInt(scanner, "Enter another integer between 1 and 100", 1, 100);

        // c. Code a loop that finds the first position of the value within the array
        boolean found = false;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userValue) {
                System.out.printf("The value %d was found at array index %d.%n", userValue, i);
                found = true;
                break; // short circuit the loop when the value is found
            }
        }
        if (!found) {
            System.out.printf("The value %d was not found in the array.%n", userValue);
        }

        // d. Write a loop to scan for the minimum and maximum values in the dataPoints array
        int min = dataPoints[0];
        int max = dataPoints[0];
        for (int i = 1; i < dataPoints.length; i++) {
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
        }
        System.out.printf("The minimum value in the dataPoints array is: %d%n", min);
        System.out.printf("The maximum value in the dataPoints array is: %d%n", max);

// e. Write a static method to calculate the average
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
    }

    public static double getAverage(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return (double) sum / values.length;
    }
}
