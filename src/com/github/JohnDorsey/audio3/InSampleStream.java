package com.github.JohnDorsey.audio3;

/**
 * Created by John on 11/30/15.
 */
public class InSampleStream {


    AudioSource parentAudioSource;
    Q content;
    InSample inSample;

    public InSampleStream(AudioSource nParentAudioSource) {
        content = new Q();
        parentAudioSource = nParentAudioSource;
        inSample = new InSample(parentAudioSource);
    }

    public Sample read() {
        return content.read();
    }


    public void fill() {
        while (addSample()) { System.out.println("InSampleStream: fill loop added sample?"); }
    }

    public boolean addSample() {
        boolean result = content.canAdd();
        if (result) { content.add(inSample.getNext()); }
        return result;
    }



}
