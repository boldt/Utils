package de.dennis_boldt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

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

    public static byte[] toByteArray(File f) throws IOException {
		// TODO: Evaluate/Benchmark: Commons-IO/Guava/JDK-7/
		//
		// (1) 	Guava:
		// 		Files.toByteArray(File file) method
		// (2) 	JDK-7:
		// 		Path path = Paths.get("path/to/file");
		// 		byte[] data = Files.readAllBytes(path);
		// (3) 	DigestInputStream
		//		http://www.javablogging.com/sha1-and-md5-checksums-in-java/
		// (4)	Source
		//		http://nadeausoftware.com/articles/2008/02/java_tip_how_read_files_quickly
    	return IOUtils.toByteArray(new FileInputStream(f));
    }

}
