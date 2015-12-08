/**
 * Created by John on 11/17/15.
 */

package com.github.JohnDorsey.audio3;

public class Audio3 {

    public static int r = 0;

    public static Sample storedSound[] = new Sample[524288];
    public static AudioSource audioSource = new AudioSource();
    public static AudioOut audioOut;

    public static void main(String[] args) {


        System.out.println("Audio3.main: creating audioOut");

        audioOut = new AudioOut("speakers", audioSource.fileName, audioSource.audioFormat);

        System.out.println("Audio3.main: created audioOut");
        audioSource.start();

        try { Thread.sleep((long) 500); } catch (InterruptedException e) { }

        //for (int i = 0; i < (48000 * 50); i++) { audioSource.read(); }
            //storedSound[i] = audioSource.read();
            //audioOut.write(storedSound[i]);

            //System.out.println("Audio3.main: " + i + " = " + storedSound[i].toString());
        //}

        SaveTo saveTo = new SaveTo("save.txt");
        LoadFrom loadFrom = new LoadFrom("save.txt");


        for (int i = 0; i < 524288; i++) {
            saveTo.write(audioSource.read().getBoth());
        }

        for (int i = 0; i < 524288; i++) {
            audioOut.write(loadFrom.read());
        }
        

        //while (1==1) {
        //    audioOut.write(audioSource.read());
        //}




        /*

        audioSource.inSampleStream.stop();

        System.out.println("Audio3.main: loaded sound");

        //for (int i = 0; i < 32768; i++) {
            //audioOut.write(audioSource.read());
        for (int i = 0; i < 524288; i++) {
            audioOut.write(storedSound[i]);

        }
            //audioOut.write(storedSound);
        //System.out.println("inSampleStream has stopped");
       //}

*/

    }

}
