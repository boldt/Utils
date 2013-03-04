package de.dennis_boldt.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

import org.apache.commons.io.IOUtils;

import de.dennis_boldt.helpers.CLibrary;

/*
 * TODO:
 * @see: http://www.onyxbits.de/content/blog/patrick/how-deal-filesystem-softlinkssymbolic-links-java
 * @see: http://www.javabeat.net/2012/07/creating-hard-links-and-soft-links-for-a-file-in-java/
 * @see: http://www.tutego.de/blog/javainsel/2011/06/dateien-kopieren-und-verschieben-mit-files-methode-in-java-7/
 * @see: http://docs.oracle.com/javase/tutorial/essential/io/links.html
 */
/**
 * Utils for files
 *
 * @author Dennis Boldt
 *
 */
public class FileUtil {

	/*
	 * TODO: testing
	 */
    public static void writeToFile(InputStream inStream,
            File to) throws FileUtilException, IOException {

        if(to.exists()) {
			throw new FileUtilException("The file " + to.getAbsolutePath() + " exists!");
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

    /*
     * TODO: implement
     */
    public static void appendToFile(File to) throws Exception {
    	throw new Exception("Not implemented yet!");
    }


    /**
     * Gets the byte array of a file
     *
     * @param f the file
     * @return the byte array
     * @throws FileUtilException if something wents wrong
     */
    public static byte[] toBytes(File f) throws FileUtilException {
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
    	try {
			return IOUtils.toByteArray(new FileInputStream(f));
		} catch (FileNotFoundException e) {
			throw new FileUtilException(e);
		} catch (IOException e) {
			throw new FileUtilException(e);
		}
    }

    /**
     * Creates a hard link of a file
     *
     * @see: http://stackoverflow.com/a/3023349/605890
     * @param from The source the file
     * @param to the destination file
     * @return
     */
	public static int hardLink(File from, File to) {
		/*
		 * TODO: Java 7
		 * Files.createLink(hLink, file1);
		 * Files.createSymbolicLink(sLink, file1);
		 */
		return CLibrary.INSTANCE.link(from.getAbsolutePath(), to.getAbsolutePath());
	}

	/**
	 * Copies a file
	 *
	 * @see: http://www.javalobby.org/java/forums/t17036.html
	 * @param from The source the file
	 * @param to the destination file
	 * @param overwrite true, if the destination file should be overwritten, otherwise false
	 * @throws FileUtilException thrown, if any error is happening during the copy
	 */
	public static void copy(File from, File to, boolean overwrite) throws FileUtilException {

		 // TODO: Java 7
		 // Files.copy(hLink, file1);
		if (!to.exists()) {
			try {
	        	if(!to.createNewFile()) {
	        		throw new FileUtilException("Creating the new file " + to.getAbsolutePath() + " failed!");
	        	}
			} catch (IOException e) {
				throw new FileUtilException(e);
			}
		} else if (!overwrite && to.exists()) {
			throw new FileUtilException("The file " + to.getAbsolutePath() + " exists!");
		}

		FileChannel source = null;
		FileChannel destination = null;
		try {
			source = new FileInputStream(from).getChannel();
			destination = new FileOutputStream(to).getChannel();
			destination.transferFrom(source, 0, source.size());
		} catch (FileNotFoundException e) {
			throw new FileUtilException(e);
		} catch (IOException e) {
			throw new FileUtilException(e);
		} finally {
			if (source != null) {
				try {
					source.close();
				} catch (IOException e) {
					throw new FileUtilException(e);
				}
			}
			if (destination != null) {
				try {
					destination.close();
				} catch (IOException e) {
					throw new FileUtilException(e);
				}
			}
		}
	}

	/**
	 * Moved a file
	 *
	 * @param from The source the file
	 * @param to the destination file
	 * @param overwrite true, if the destination file should be overwritten, otherwise false
	 * @return
	 * @throws FileUtilException
	 */
	public static void move(File from, File to, boolean overwrite) throws FileUtilException {
		// TODO: Java 7
		// Files.move(hLink, file1);
		// @see http://www.java-forum.org/allgemeine-java-themen/84189-effektives-file-move-copy.html#post525503

        if(overwrite && to.exists()) {
        	if(!to.delete()) {
        		throw new FileUtilException("The file " + to.getAbsolutePath() + " cannot be deleted!");
        	}
        } else if (!overwrite && to.exists()) {
			throw new FileUtilException("The file " + to.getAbsolutePath() + " exists!");
        }

        if(!from.renameTo(to)) {
        	throw new FileUtilException("Renaming the file " + from.getAbsolutePath() + " to " + to.getAbsolutePath() + " failed!");
        }
    }

	/**
	 * Gets the mime type for a given file
	 *
	 * @see: http://www.rgagnon.com/javadetails/java-0487.html
	 * @param file The file
	 * @return The mime type
	 * @throws MimeTypeException
	 */
    public static String getMimeType(File file) throws FileUtilException {
        String type = null;
        try {
        	MagicMatch  match = Magic.getMagicMatch(file, false);
            type = match.getMimeType();
        } catch (Exception e) { }

        if (type == null || "???".equals(type)) {
            throw new FileUtilException("Mime type cannot be determined.");
        }

        return type;
    }

}
