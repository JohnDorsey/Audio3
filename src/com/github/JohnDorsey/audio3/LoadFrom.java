package com.github.JohnDorsey.audio3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by John on 12/8/15.
 */
public class LoadFrom {

    public FileInputStream fileInputStream;
    public File loadingFrom;
    public String fileName;

    public LoadFrom(String nFileName) {
        loadingFrom = new File(nFileName);
        try {
            fileInputStream = new FileInputStream(loadingFrom);
        } catch (FileNotFoundException cantFind) { }
    }

    public byte read() {
        byte result = (byte) 0;
        try {
            result = (byte) fileInputStream.read();
        } catch (IOException ioe) { }
        return result;
    }


}
