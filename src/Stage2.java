import java.util.*;

public class Stage2 {

    static void exercise1() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Julie");
        names.add("Tom");
        int size = names.size();
        System.out.println("List size: " + size);
        System.out.println("First name in the list: " + names.getFirst());
        System.out.println("Last name in the list: " + names.get(size - 1));
        System.out.println("Names in the list: ");
        for (String name : names) {
            System.out.println(name);
        }
    }

    static void exercise2() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Julie");
        names.add("Tom");
        names.add("Adam");
        System.out.println("Contains Tom: " + names.contains("Tom"));
        names.remove("Tom");
        System.out.println("Contains Tom: " + names.contains("Tom"));
    }

    static void exercise3() {
        Map <String, Integer> grades = new HashMap<>();
        grades.put("Math", 3);
        grades.put("Computer", 4);
        grades.put("Physics", 2);
        grades.put("Engineer", 3);

        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            String subject = entry.getKey();
            int grade = entry.getValue();
            System.out.println(subject + ": " + grade);
        }

        int sum = 0;
        for (int grade : grades.values()) {
            sum += grade;
        }
        double average = (double) sum / grades.size();
        System.out.println("Average: " + average);
    }

    static void exercise4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();

        Map<Character, Integer> counter = new HashMap<>();

        for (char i : sentence.toCharArray()) {
            counter.put(i, counter.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Character, Integer> result : counter.entrySet()) {
            Character letter = result.getKey();
            System.out.println(letter + ": " + result.getValue());
        }
    }

    static void exercise5() {
        List<Integer> raw = new ArrayList<>();
        raw.add(5);
        raw.add(3);
        raw.add(5);
        raw.add(8);
        raw.add(3);
        raw.add(1);
        System.out.println("ArrayList length: " + raw.size());

        Set<Integer> set = new HashSet<>();
        for (Integer i : raw) {
            set.add(i);
        }
        System.out.println("Set length: " + set.size());
    }

    static void exercise6() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String sentence = scanner.nextLine();

        Map<Character, Integer> letter = new HashMap<>();

        for (char i : sentence.toCharArray()) {
            letter.put(i, letter.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Character, Integer> result : letter.entrySet()) {
            Character key = result.getKey();
            System.out.println(key + ": " + result.getValue());
        }

        Set<Character> repeated = new HashSet<>();

        for (Map.Entry<Character, Integer> result : letter.entrySet()) {
            if (result.getValue() > 1) {
                repeated.add(result.getKey());
            }
        }
        System.out.println("Repeated letters: " + repeated);
    }

    public static void main(String[] args) {
        exercise6();
    }
}