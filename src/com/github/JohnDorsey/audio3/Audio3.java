/**
 * Created by John on 11/17/15.
 */

package com.github.JohnDorsey.audio3;

public class Audio3 {

    public static int r = 0;

    //public static Sample storedSound[] = new Sample[32768];
    public static AudioSource audioSource = new AudioSource();
    public static AudioOut audioOut;

    public static void main(String[] args) {

        audioOut = new AudioOut("speakers", audioSource.fileName, audioSource.audioFormat);

        //for (int i = 0; i < 32768; i++) {
            //storedSound[i] = audioSource.read();
        //}

        for (int i = 0; i < 32768; i++) {
            audioOut.write(audioSource.read());
        }



    }

}
