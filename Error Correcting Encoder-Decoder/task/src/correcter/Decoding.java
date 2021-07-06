package correcter;

import correcter.innerlogic.EncoderDecoder;

public class Decoding extends UserActionTemplate {
    private final EncoderDecoder encDec = new EncoderDecoder();

    @Override
    byte[] transformBytes(byte[] bytes) {
        return encDec.decode(bytes);
    }
}
