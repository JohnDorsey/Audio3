package com.github.JohnDorsey.audio3;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.SourceDataLine;
import java.io.File;

/**
 * Created by John on 11/30/15.
 */
public class AudioSource {

    public String fileName = "clink1.wav";

    public AudioFormat audioFormat;
    public AudioInputStream audioInputStream;
    public SourceDataLine sourceDataLine;
    public File openFile;

    InSampleStream inSampleStream = new InSampleStream(this);

    public Sample read() {
        inSampleStream.fill();
        return inSampleStream.read();
    }


}
