import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        int wordsCount = 0;

        int bt = reader.read();
        while (bt != -1) {
            if (bt == ' ') {
                bt = reader.read();
                continue;
            }

            if (bt != -1) {
                bt = reader.read();

                if (bt == ' ' || bt == -1) {
                    wordsCount++;
                    bt = reader.read();
                }
            }
        }

        System.out.println(wordsCount);
        reader.close();
    }
}