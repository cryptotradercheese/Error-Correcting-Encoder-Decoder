package correcter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        System.out.print("Write a mode: ");
        String mode = scanner.nextLine();
        System.out.println();

        switch (mode) {
            case "encode":
                Encoding encoding = new Encoding();
                encoding.execute("send.txt", "encoded.txt");
                break;
            case "send":
                Sending sending = new Sending();
                sending.execute("encoded.txt", "received.txt");
                break;
            case "decode":
                Decoding decoding = new Decoding();
                decoding.execute("received.txt", "decoded.txt");
                break;
            default:
                System.out.print("There is no such mode");
                break;
        }
    }
}