package de.dennis_boldt.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

    public static void writeToFile(InputStream inStream,
            File to) throws FileExistsException, IOException {

        if(to.exists()) {
            throw new FileExistsException(to);
        }

        // Create a new file
        to.createNewFile();

        OutputStream out = new FileOutputStream(to);
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = inStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    }

}
