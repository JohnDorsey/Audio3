package com.github.JohnDorsey.audio3;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;
import java.io.File;

/**
 * Created by John on 11/30/15.
 */
public class AudioSource {

    public String fileName; // = "dontStop (1).wav";
    public String type;

    public AudioFormat audioFormat;
    public AudioInputStream audioInputStream;
    public SourceDataLine sourceDataLine;
    public File openFile;

    InSampleStream inSampleStream;

    public AudioSource(String nFileName, String nType) {
        fileName = nFileName;
        type = nType;
        inSampleStream = new InSampleStream(this);
    }


    public void start() {
        inSampleStream.start();
    }

    public Sample read() {

        return inSampleStream.read();
    }


}
