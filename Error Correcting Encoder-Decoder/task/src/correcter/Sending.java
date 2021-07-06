package correcter;

import correcter.innerlogic.PoorInternetConnection;

public class Sending extends UserActionTemplate {
    private final PoorInternetConnection connection = new PoorInternetConnection();

    @Override
    byte[] transformBytes(byte[] bytes) {
        return connection.emulateErrors(bytes);
    }
}
