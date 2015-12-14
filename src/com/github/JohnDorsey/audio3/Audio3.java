/**
 * Created by John on 11/17/15.
 */

package com.github.JohnDorsey.audio3;

public class Audio3 {

    public static int r = 0;

    public static Sample storedSound[] = new Sample[524288];
    public static AudioSource audioSource = new AudioSource();
    public static AudioOut audioOut;

    public static boolean endnow = false;

    public static void main(String[] args) {


        System.out.println("Audio3.main: creating audioOut");

        audioOut = new AudioOut("speakers", audioSource.fileName, audioSource.audioFormat);

        System.out.println("Audio3.main: created audioOut");
        audioSource.start();

        try { Thread.sleep((long) 500); } catch (InterruptedException e) { }



        //SaveTo saveTo = new SaveTo("save.txt");
        LoadFrom loadFrom = new LoadFrom("save.txt");




        System.out.println("writing...");

        Sample writeT;
        //while (!endnow) {
        //    writeT = audioSource.read();
        //    saveTo.write(writeT.getBoth());
        //}

        //System.out.println("done with write loop");

        //for (int i = 0; i < 131072; i++) {

        endnow = false;
        while (!endnow) {
            writeT = new Sample(loadFrom.read(), loadFrom.read());
            audioOut.play(writeT);
            //audioOut.play(new Sample(loadFrom.read(), loadFrom.read()));
            //audioOut.play(new Sample(loadFrom.read(), loadFrom.read()));
        }


        System.out.println("played once");

        endnow = false;
        while (!endnow) {
            audioOut.play(new Sample(loadFrom.read(), loadFrom.read()));
            //writeT = new Sample(loadFrom.read(), loadFrom.read());
        }

        System.out.println("ended");








    }

    public static void endof() {
        endnow = true;
    }

}


//for (int i = 0; i < (48000 * 50); i++) { audioSource.read(); }
//storedSound[i] = audioSource.read();
//audioOut.write(storedSound[i]);

//System.out.println("Audio3.main: " + i + " = " + storedSound[i].toString());
//}


//while (1==1) {
//    audioOut.write(audioSource.read());
//}