package de.dennis_boldt.utils;

import java.io.File;

import net.sf.jmimemagic.Magic;
import net.sf.jmimemagic.MagicMatch;

/**
 *
 * @author Dennis Boldt
 *
 * @see: http://www.rgagnon.com/javadetails/java-0487.html
 */
public class MimeTypeUtil {

    public static String getMimeType(File file) throws MimeTypeUtilException {
        String type = null;

        // Try the jmimemagic library
        MagicMatch match;
        try {
            match = Magic.getMagicMatch(file, false);
            type = match.getMimeType();
        } catch (Exception e) {
            throw new MimeTypeUtilException(e);
        }

        if (type == null) {
            throw new MimeTypeUtilException("Mime type cannot be determined.");
        }

        return type;
    }

}
