package correcter;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final Random random = new Random();


        StringBuilder input = new StringBuilder(scanner.nextLine());

        for (int start = 0, end = 2; end < input.length(); start += 3, end += 3) {
            int errorIndex = random.nextInt(end - start + 1) + start;
            char errorChar = (char) (random.nextInt(122 - 97 + 1) + 97);

            input.setCharAt(errorIndex, errorChar);
        }
        System.out.println(input);
    }
}
