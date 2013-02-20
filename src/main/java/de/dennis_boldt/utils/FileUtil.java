package de.dennis_boldt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import org.apache.commons.io.IOUtils;

/*
 * TODO:
 * @see: http://www.onyxbits.de/content/blog/patrick/how-deal-filesystem-softlinkssymbolic-links-java
 */
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

	/*
	 * TODO: Java 7
	 * @see: http://www.javabeat.net/2012/07/creating-hard-links-and-soft-links-for-a-file-in-java/
	 * @see: http://www.tutego.de/blog/javainsel/2011/06/dateien-kopieren-und-verschieben-mit-files-methode-in-java-7/
	 * @see: http://docs.oracle.com/javase/tutorial/essential/io/links.html
	 *
	 * Files.createLink(hLink, file1);
	 * Files.createSymbolicLink(sLink, file1);
	 * Files.copy(hLink, file1);
	 * Files.move(hLink, file1);
	 */

	/*
	 * @see: http://stackoverflow.com/a/3023349/605890
	 */
	public static int hardLink(File from, File to) {
		return CLibrary.INSTANCE.link(from.getAbsolutePath(), to.getAbsolutePath());
	}

	/*
	 * @see: http://www.javalobby.org/java/forums/t17036.html
	 */
	public static void copy(File sourceFile, File destFile)
			throws IOException {
		if (!destFile.exists()) {
			destFile.createNewFile();
		}

		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			destination.transferFrom(source, 0, source.size());
		} finally {
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		}
	}

	/*
	 * @see http://www.java-forum.org/allgemeine-java-themen/84189-effektives-file-move-copy.html#post525503
	 */
	public static boolean move(File from, File to) {
		// TODO: überschreiben nachfragen!

        if(to.exists()) {
        	to.delete();
        }
        return from.renameTo(to);
    }

}
