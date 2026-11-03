import java.util.InputMismatchException;
import java.util.Scanner;

public class Stage4 {

    static void exercise1() {
        Scanner scanner = new Scanner(System.in);

        try {
            String text = scanner.nextLine();
            int number = Integer.parseInt(text);

            System.out.println("Parsed number: " + number);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        }
    }

    static void exercise2() {
        Scanner scanner = new Scanner(System.in);

        try {
            int number1 = scanner.nextInt();
            int number2 = scanner.nextInt();

            int divider = number1/number2;

            System.out.println(divider);

        } catch (ArithmeticException e) {
            System.out.println("division by zero");
        }
    }

    static void exercise3() {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {1,2,3,4,5};
        try {
            int index = scanner.nextInt();
            int select = numbers[index - 1];
            System.out.println(select);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Input out of bounds");
        }
    }

    static void exercise4() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("First number: ");
            int number1 = scanner.nextInt();
            System.out.println("Second number: ");
            int number2 = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Sign: ");
            String sign = scanner.nextLine();

            if (sign.equals("+")) {
                System.out.println(number1 + number2);
            } else if (sign.equals("-")) {
                System.out.println(number1 - number2);
            } else if (sign.equals("*")) {
                System.out.println(number1 * number2);
            } else if (sign.equals("/")) {
                System.out.println(number1 / number2);
            } else if (sign.equals("%")) {
                System.out.println(number1 % number2);
            } else {
                System.out.println("Please enter a valid sign");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid number");
        } catch (ArithmeticException e) {
            System.out.println("Division by zero");
        }
    }

    static void exercise5() {
        Scanner scanner = new Scanner(System.in);

        try {
            String text = scanner.nextLine();
            int number = Integer.parseInt(text);

            System.out.println("Parsed number: " + number);

        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
        } finally {
            System.out.println("program done");
        }
    }

    static void checkAge(int age) {
        if (age < 0 || age > 130) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        System.out.println("Your age is: " + age);
    }

    static void exercise6() {
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();

        try {
            checkAge(age);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        exercise6();
    }
}
