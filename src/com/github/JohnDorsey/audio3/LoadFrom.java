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
        } catch (FileNotFoundException cantFind) { System.err.println("LoadFrom.LoadFrom(String): FileNotFoundException! " + cantFind)}
    }

    public byte read() {
        int result = 0;
        try {
            result = fileInputStream.read();
        } catch (IOException ioe) { System.err.println("LoadFrom.read(): IOException! " + ioe); }
        if (result == -1 ) { System.out.println("LoadFrom.read(): it's al over!"); Audio3.endof(); }
        return (byte) result;
    }

    public byte[] read2() {
        return new byte[] {read(), read()};
    }


}
