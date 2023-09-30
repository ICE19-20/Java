import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Java Calculator!");
        while (true) {
            System.out.println("Choose an operation:");
            System.out.println("Addition : +");
            System.out.println("Subtraction : -");
            System.out.println("Multiplication : *");
            System.out.println("Division : /");
            System.out.println("Exit: exit");

            String choice = scanner.nextLine();
            // System.out.println(choice);
            // System.out.println(choice.length());
            if (choice.contains("exit")) {
                System.out.println("Thank you for using the calculator. Goodbye!");
                break;
            }
            double result = 0;

            try {
                System.out.print("Enter the first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter the second number: ");
                double num2 = scanner.nextDouble();

                switch (choice) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            throw new ArithmeticException("cannot divide with 0");
                        }
                        result = num1 / num2;
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid operation.");
                        continue; // Go back to the menu
                }

                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }

            scanner.nextLine(); // Consume the newline character
        }

        scanner.close();
    }
}
