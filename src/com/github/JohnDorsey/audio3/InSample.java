/**
 * Created by John on 11/17/15.
 */

package com.github.JohnDorsey.audio3;

import javax.sound.sampled.*;
import java.io.File;
import java.util.Random;



public class InSample {

    public AudioSource parentAudioSource;


    public InSample(AudioSource nParentAudioSource){
        parentAudioSource = nParentAudioSource;

        try {
            parentAudioSource.openFile = new File(parentAudioSource.fileName);
            parentAudioSource.audioInputStream = AudioSystem.getAudioInputStream(parentAudioSource.openFile);
            parentAudioSource.audioFormat = parentAudioSource.audioInputStream.getFormat();
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, parentAudioSource.audioFormat);
            parentAudioSource.sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        } catch (Exception e) { System.err.println(e); }

    }

    public Sample getNext(){
        Sample nextSample = new Sample((byte) 0, (byte) 0);
        try {
            parentAudioSource.audioInputStream.read(nextSample.bytes, 0, 2);
        } catch (Exception e) { System.out.println(e); }
        return nextSample;
    }
    




}
