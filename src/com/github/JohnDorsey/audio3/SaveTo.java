package com.github.JohnDorsey.audio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by John on 12/8/15.
 */
public class SaveTo {

    public FileOutputStream fileOutputStream;
    public File savingTo;
    public String fileName;

    public SaveTo(String nFileName) {
        fileName = nFileName;
        savingTo = new File(fileName);
        try {
            fileOutputStream = new FileOutputStream(savingTo);
        } catch (FileNotFoundException cantFind) { }
    }

    public void write(byte toWrite) {
        try {
            fileOutputStream.write((int) toWrite);
        } catch (IOException ioe) { }
    }


}
