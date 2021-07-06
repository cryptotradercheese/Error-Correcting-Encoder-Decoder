package correcter.innerlogic;

import java.io.ByteArrayOutputStream;

public class EncoderDecoder {
    public byte[] encode(byte[] bytes) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        for (int i = 0; i < bytes.length; i++) {
            BitOperations currentByte = new BitOperations(bytes[i]);

            for (int j = 0; j < 2; j++) {
                BitOperations encodedByte = new BitOperations(0);

                int d3 = currentByte.getBitAt(7 - 4 * j);
                int d5 = currentByte.getBitAt(6 - 4 * j);
                int d6 = currentByte.getBitAt(5 - 4 * j);
                int d7 = currentByte.getBitAt(4 - 4 * j);

                int p1 = BitOperations.addBitsInOneBit(d3, d5, d7);
                int p2 = BitOperations.addBitsInOneBit(d3, d6, d7);
                int p4 = BitOperations.addBitsInOneBit(d5, d6, d7);
                int p8 = 0;

                encodedByte.setBitAt(7, p1);
                encodedByte.setBitAt(6, p2);
                encodedByte.setBitAt(5, d3);
                encodedByte.setBitAt(4, p4);
                encodedByte.setBitAt(3, d5);
                encodedByte.setBitAt(2, d6);
                encodedByte.setBitAt(1, d7);
                encodedByte.setBitAt(0, p8);

                output.write(encodedByte.getNum());
            }
        }

        return output.toByteArray();
    }

    public byte[] decode(byte[] bytes) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        BitOperations decodedByte = new BitOperations(0);

        for (int i = 0; i < bytes.length; i++) {
            BitOperations correctCurrentByte = new BitOperations(decodeByteWithError(bytes[i]));

            int d3 = correctCurrentByte.getBitAt(5);
            int d5 = correctCurrentByte.getBitAt(3);
            int d6 = correctCurrentByte.getBitAt(2);
            int d7 = correctCurrentByte.getBitAt(1);

            decodedByte.setBitAt(7 - 4 * (i % 2), d3);
            decodedByte.setBitAt(6 - 4 * (i % 2), d5);
            decodedByte.setBitAt(5 - 4 * (i % 2), d6);
            decodedByte.setBitAt(4 - 4 * (i % 2), d7);

            if (i % 2 == 1) {
                output.write(decodedByte.getNum());
            }
        }

        return output.toByteArray();
    }

    private int decodeByteWithError(byte bt) {
        BitOperations currentByte = new BitOperations(bt);

        int d3 = currentByte.getBitAt(5);
        int d5 = currentByte.getBitAt(3);
        int d6 = currentByte.getBitAt(2);
        int d7 = currentByte.getBitAt(1);

        int p1 = BitOperations.addBitsInOneBit(d3, d5, d7);
        int p2 = BitOperations.addBitsInOneBit(d3, d6, d7);
        int p4 = BitOperations.addBitsInOneBit(d5, d6, d7);

        int realP1 = currentByte.getBitAt(7);
        int realP2 = currentByte.getBitAt(6);
        int realP4 = currentByte.getBitAt(4);

        boolean isP1Correct = realP1 == p1;
        boolean isP2Correct = realP2 == p2;
        boolean isP4Correct = realP4 == p4;

        int incorrectIndex = 0;
        if (!isP1Correct) {
            incorrectIndex += 1;
        }
        if (!isP2Correct) {
            incorrectIndex += 2;
        }
        if (!isP4Correct) {
            incorrectIndex += 4;
        }

        if (incorrectIndex != 0) {
            currentByte.invertBitAt(7 - incorrectIndex + 1);
        }

        return currentByte.getNum();
    }
}