/**
 * Created by John on 11/17/15.
 */

package com.github.JohnDorsey.audio3;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Random;



public class InSample {

    public AudioSource parentAudioSource;
    public LoadFrom loadFrom;


    public InSample(AudioSource nParentAudioSource) {
        parentAudioSource = nParentAudioSource;
        loadFrom = new LoadFrom(parentAudioSource.fileName);


        try {
            parentAudioSource.audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100.0f, 16, 1, 2, 44100.0f, false);
        } catch (Exception e) { System.err.println("InSample.InSample(AudioSource): " + e); }




        try {
            parentAudioSource.openFile = new File(parentAudioSource.fileName);
            parentAudioSource.audioInputStream = AudioSystem.getAudioInputStream(parentAudioSource.openFile);
            //parentAudioSource.audioFormat = parentAudioSource.audioInputStream.getFormat();
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, parentAudioSource.audioFormat);
            parentAudioSource.sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        } catch (Exception e) { System.err.println("InSample.InSample(AudioSource): " + e); }



    }

    public Sample getNext(){
        Sample nextSample = new Sample((byte) 0, (byte) 0);
        try {
            //if (parentAudioSource.type == "wav") {
                //if (
                        parentAudioSource.audioInputStream.read(nextSample.bytes, 0, 2);
                //                == -1) { Audio3.endof(); }
            //} else if (parentAudioSource.type == "raw") {
            //    nextSample.bytes = loadFrom.read2();
            //}
        } catch (Exception e) { System.err.println("InSample.getNext(): " + e); }
        return nextSample;
    }


    




}
