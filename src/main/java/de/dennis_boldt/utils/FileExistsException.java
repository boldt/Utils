package de.dennis_boldt.utils;

import java.io.File;


/**
 *
 * @author Dennis Boldt
 *
 */
public class FileExistsException extends Exception {

    private static final long serialVersionUID = 1L;

    public FileExistsException(File f) {
        super("File " + f.getName() + " exists!");
    }

}