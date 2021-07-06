package correcter.innerlogic;

class BitOperations {
    private int num;

    BitOperations(int num) {
        this.num = num;
    }

    int getNum() {
        return this.num;
    }

    int getBitAt(int position) {
        int currentBit = num & 1 << position;
        return currentBit >>> position;
    }

    int setBitAt(int position, int bit) {
        if (bit != 0 && bit != 1) {
            throw new IllegalArgumentException("Bit can be 0 or 1");
        }

        if (bit == 0) {
            num = num & new BitOperations(~0).invertBitAt(position);
        } else {
            num = num | 1 << position;
        }

        return num;
    }

    int invertBitAt(int position) {
        num = num ^ 1 << position;
        return num;
    }

    static int addBitsInOneBit(int... bits) {
        int bitsInOneBit = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] != 0 && bits[i] != 1) {
                throw new IllegalArgumentException("Bits can be 0 or 1");
            }

            bitsInOneBit += bits[i];
        }

        return new BitOperations(bitsInOneBit).getBitAt(0);
    }
}