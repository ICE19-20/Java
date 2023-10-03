import java.util.Scanner;

class negativeNumberException extends Exception {
    public negativeNumberException(String message) {
        super(message);
    }
}

public class negativeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Input Your Number please\n>");
                int number = input.nextInt();
                if (number == 0) {
                    System.out.println("Done Watching");
                    break;
                }
                if (number < 0) {
                    throw new negativeNumberException("We do not like negative numbers");
                }
                System.out.println("Your number is " + number);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}
