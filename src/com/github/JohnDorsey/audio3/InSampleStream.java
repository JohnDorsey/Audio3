package com.github.JohnDorsey.audio3;

/**
 * Created by John on 11/30/15.
 */
public class InSampleStream extends Thread {


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

    @Override
    public void run() {
        while (1==1) {
            //try { Thread.sleep(10); } catch (InterruptedException e) { }
            //fill();
            addSample();
        }
    }

    public void fill() {
        while (addSample()) {
            //System.out.println("InSampleStream: fill loop added sample?");
        }
        //while (content.travel < 4096) { addSample(); }
        //for (int i = 0; i < 128 && addSample(); i++) { }
        //System.out.println("InSampleStream.fill: full");
    }

    public boolean addSample() {
        boolean result = content.canAdd();
        if (result) { content.add(inSample.getNext()); }
        //System.out.println("InSampleStream.addSample: result: " + result);
        return result;
    }



}
