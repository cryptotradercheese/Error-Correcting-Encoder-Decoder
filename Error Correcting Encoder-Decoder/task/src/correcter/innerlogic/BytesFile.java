package correcter.innerlogic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BytesFile {
    public byte[] readBytesFromFile(File file) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (FileInputStream input = new FileInputStream(file)) {
            int ch = input.read();
            while (ch != -1) {
                output.write(ch);
                ch = input.read();
            }
        }

        return output.toByteArray();
    }

    public void writeBytesToFile(byte[] bytes, File file) throws IOException {
        try (FileOutputStream output = new FileOutputStream(file)) {
            output.write(bytes);
        }
    }
}
