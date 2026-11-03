import java.util.Scanner;

public class Stage1 {

     static void exercise1() {
        int age = 33;
        double height = 1.7;
        boolean student = true;
        String name = "Przemek";

        System.out.println("age: " + age + " height: " + height + " student: "+ student + " name: " + name);
    }

    static void exercise2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Your name: ");
        String name = scanner.nextLine();

        System.out.println("Your age: ");
        int age = scanner.nextInt();

        System.out.println("Hi " + name + " in 10 years you will be " + (age + 10) + " years old.");
    }

    static void exercise3() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First number: ");
        double number1 = scanner.nextDouble();
        System.out.println("Second number: ");
        double number2 = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Sign: ");
        String sign = scanner.nextLine();

        if (sign.equals("+")) {
            System.out.println(number1 + " + " + number2 + " = " + (number1 + number2));
        }  else if (sign.equals("-")) {
                System.out.println(number1 + " - " + number2 + " = " + (number1 - number2));
        }   else if (sign.equals("*")) {
                System.out.println(number1 + " * " + number2 + " = " + (number1 * number2));
        }   else if (sign.equals("/")) {
                if (number2 == 0){
                    System.out.println("Cannot divide by zero");
            }   else {
                    System.out.println(number1 + " / " + number2 + " = " + (number1 / number2));
                }
        }   else if (sign.equals("%")) {
                System.out.println(number1 + " % " + number2 + " = " + (number1 % number2));
        }   else {
                System.out.println("Please enter a valid sign (+, -, *, /, %)");
        }
    }

    static void exercise4() {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Parity check, enter a number: ");
         int number = scanner.nextInt();
         int parity = Math.abs(number % 2);

         switch (parity) {
             case 0:
                 System.out.println("even number");
                 break;
             case 1:
                 System.out.println("odd number");
                 break;
         }
    }

    static void exercise5() {
         int [] numbers = {10, 20, 30, 40, 50};
         int length = numbers.length;
         System.out.println(length);
         System.out.println();

         for (int i = 0; i < length; i++) {
             System.out.println(numbers[i]);
         }
    }

    static void exercise6() {
        int [] array = {76, 30, 23, 5, 12};
        int length = array.length;

        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += array[i];
        }

        System.out.println(sum);
        double average_rating = (double) sum / length;
        System.out.println(average_rating);
    }

    public static void main(String[] args) {
         exercise6();
    }

}