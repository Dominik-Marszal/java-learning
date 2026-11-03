import java.util.List;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class IsPrimetxt {

    static boolean isPrime(int n){
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Path file = Path.of("numbers.txt");
        List <String> numbers = new ArrayList<>();

        if(Files.exists(file)) {
            try {
                List<String> lines = Files.readAllLines(file);
                numbers.addAll(lines);
            } catch (IOException e) {
                System.out.println("Read error: " + e.getMessage());
            }
        }

        List<Integer> primes = numbers.stream()
                .map(Integer::parseInt)
                .filter(IsPrimetxt::isPrime)
                .collect(Collectors.toList());

        List<String> lines = primes.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        try {
            Files.write(Path.of("primes.txt"), lines);
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }

        System.out.println(primes);
    }
}
