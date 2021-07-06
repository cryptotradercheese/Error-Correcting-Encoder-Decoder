package correcter;

import java.io.File;
import java.io.IOException;
import correcter.innerlogic.BytesFile;

public abstract class UserActionTemplate {
    private final BytesFile bytesFile = new BytesFile();

    public void execute(String input, String output) {
        File inputFile = new File(input);
        File outputFile = new File(output);

        try {
            byte[] bytes = bytesFile.readBytesFromFile(inputFile);
            byte[] transformedBytes = transformBytes(bytes);
            bytesFile.writeBytesToFile(transformedBytes, outputFile);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    abstract byte[] transformBytes(byte[] bytes);
}
