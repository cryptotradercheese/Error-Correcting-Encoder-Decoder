package correcter.innerlogic;

import java.util.Random;
import java.util.Arrays;

public class PoorInternetConnection {
    private final Random random = new Random();

    public byte[] emulateErrors(byte[] bytes) {
        byte[] returnBytes = Arrays.copyOf(bytes, bytes.length);

        for (int i = 0; i < returnBytes.length; i++) {
            int randPosition = random.nextInt(8);
            returnBytes[i] = (byte) new BitOperations(returnBytes[i]).invertBitAt(randPosition);
        }

        return returnBytes;
    }
}