import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        CharArrayWriter writer = new CharArrayWriter();

        int ch;
        while ((ch = reader.read()) != -1) {
            writer.write(ch);
        }

        char[] chars = writer.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
        reader.close();
        writer.close();
    }
}