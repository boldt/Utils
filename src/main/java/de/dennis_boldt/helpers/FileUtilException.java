package de.dennis_boldt.helpers;



/**
 *
 * @author Dennis Boldt
 *
 */
public class FileUtilException extends Exception {

    private static final long serialVersionUID = 1L;

    public FileUtilException(String message) {
        super(message);
    }

    public FileUtilException(Exception e) {
        super(e);
    }

}