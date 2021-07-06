import java.io.InputStream;
import java.io.ByteArrayOutputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int ch;
        while ((ch = inputStream.read()) != -1)  {
            output.write(ch);
        }

        for (byte bt : output.toByteArray()) {
            System.out.print(bt);
        }
    }
}