import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;
import java.nio.file.*;
import java.io.IOException;

public class Stage5 {

    static void exercise1() {
        Runnable one = () -> System.out.println("one");
        Runnable two = () -> System.out.println("two");
        Runnable three = () -> System.out.println("three");
        one.run();
        two.run();
        three.run();
    }
    static void exercise2() {
        List<String> names = new ArrayList<>(List.of("Adam", "Mark", "Chad", "Fin", "Alex"));
        names.sort((a, b) -> a.compareTo(b) );
        System.out.println(names);
        names.sort((a, b) -> b.compareTo(a) );
        System.out.println(names);

        List<Integer> numbers = new ArrayList<>(List.of(5, 7, -12, 743, -20, 65));
        numbers.sort((a, b) -> Integer.compare(Math.abs(a), Math.abs(b)));

        System.out.println(numbers);
    }
    static void exercise3() {
        List<Integer> numbers = new ArrayList<>(List.of(5, 7, 12, 743, -20, 65, 853, 23, -36, -237));

        List<Integer> operationNumbers = numbers.stream()
                .filter(n -> n % 3 != 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        int sumNumbers = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(operationNumbers);
        System.out.println(sumNumbers);
    }
    static void exercise4() {
        class Pair<A, B> {
            private A first;
            private B second;

            public void setFirst(A first) { this.first = first; }
            public A getFirst() { return first; }
            public void setSecond(B second) { this.second = second; }
            public B getSecond() { return second; }
        }

        Pair<String, Integer> person = new Pair<>();
        person.setFirst("Anne");
        person.setSecond(22);

        Pair<String, Boolean> student = new Pair<>();
        student.setFirst("Adam");
        student.setSecond(false);

        System.out.println(person.getFirst() + " " + person.getSecond());
        System.out.println(student.getFirst() + " " + student.getSecond());
    }

    static void exercise5() {
        System.out.println("To do list!");

        Path file = Path.of("tasks.txt");
        Scanner scanner = new Scanner(System.in);
        List<String[]> list = new ArrayList<>();

        //Open
        if (Files.exists(file)) {
            try {
                List<String> lines = Files.readAllLines(file);
                for (String line : lines) {
                    String[] task = line.split(";");
                    list.add(task);
                }
            } catch (IOException e) {
                System.out.println("Read error: " + e.getMessage());
            }
        }

        while (true) {
            System.out.println("\n1 - Show list\n2 - Add task \n3 - Delete task \n4 - Mark as done\n5 - Close the program");

            int choose;
            try {
                System.out.print("Enter a number: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter a number!");
                continue;
            }

            if (choose == 1) {
                // show_list
                if (list.isEmpty()) {
                    System.out.println("The list is empty.");
                } else {
                    for (int i = 0; i < list.size(); i++) {
                        String[] task = list.get(i);
                        System.out.println((i + 1) + " - \"" + task[0] + "\" - " + task[1]);
                    }
                }
            }
            else if (choose == 2) {
                // add_task
                System.out.print("Enter a note for the task: ");
                String note = scanner.nextLine();
                list.add(new String[]{note, "not done"});
            }
            else if (choose == 3) {
                // remove_task
                try {
                    System.out.print("Enter which task to remove: ");
                    int number = Integer.parseInt(scanner.nextLine());
                    if (number < 1 || number > list.size()) {
                        System.out.println("Enter a valid task number!");
                        continue;
                    }
                    list.remove(number - 1);
                } catch (NumberFormatException e) {
                    System.out.println("Enter a number");
                }
            }
            else if (choose == 4) {
                // mark_task_as_done
                try {
                    System.out.print("Enter which task is done: ");
                    int number = Integer.parseInt(scanner.nextLine());
                    if (number < 1 || number > list.size()) {
                        System.out.println("Enter a valid task number!");
                        continue;
                    }
                    list.get(number - 1)[1] = "done";
                } catch (NumberFormatException e) {
                    System.out.println("Enter a number");
                }
            }
            else if (choose == 5) {
                //Save
                List<String> lines = new ArrayList<>();
                for (String[] task : list) {
                    lines.add(task[0] + ";" + task[1]);
                } try {
                    Files.write(file, lines);
                } catch (IOException e) {
                    System.out.println("Write error: " + e.getMessage());
                }
                break;
            }
            else {
                System.out.println("Enter a number from 1 to 5");
            }
        }
    }

    static void exercise6() {
        Thread a = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("A " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread b = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("B " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        a.start();
        b.start();
    }

    public static void main(String[] args) {
        exercise6();
    }
}
