package com.github.JohnDorsey.audio3;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;
import java.util.Arrays;

/**
 * Created by John on 11/30/15.
 */
public class AudioOut {

    public String type;
    public String fileName;
    static SourceDataLine sourceDataLine;
    static AudioFormat audioFormat;
    public static String blank = "                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                ";


    public AudioOut(String nType, String nFileName, AudioFormat nAudioFormat) {
        type = nType;
        fileName = nFileName;
        audioFormat = nAudioFormat;
        try {
            DataLine.Info dataLineInfo = new DataLine.Info(SourceDataLine.class, audioFormat);
            sourceDataLine = (SourceDataLine) AudioSystem.getLine(dataLineInfo);
        } catch (Exception e) { System.err.println(e); }


        open();
    }

    public void open() {
        try {
            sourceDataLine.open(audioFormat);
            sourceDataLine.start();
        } catch (Exception e) { System.err.println("AudioOut.Open(): \n" + e); }
    }

    public void close() {
        try {
            sourceDataLine.drain();
            sourceDataLine.close();
        } catch (Exception e) { System.err.println(e); }
    }

    public void write(Sample toWrite) {
        //write(new Sample[]  { toWrite } );
        write(new byte[] {toWrite.get(), toWrite.get()});
    }

    public void write(byte toWrite) {
        write(new byte[]  { toWrite } );
    }

    public void write(Sample[] toWrite) {
        byte[] bToWrite = new byte[toWrite.length * 2];
        for (int i = 0; i < toWrite.length; i++) {
            bToWrite[2 * i] = toWrite[i].get();
            bToWrite[(2 * i) + 1] = toWrite[i].get();
        }
        write(bToWrite);
    }

    public void write(byte[] toWrite) {
        if (type == "speakers") { play(toWrite);
        } else if (type == "dotDisplay") { dotDisplay(toWrite);
        } else if (type == "byteDisplay") { byteDisplay(toWrite);
        } else { System.err.println("AudioOut.write: no such type: " + type); }
    }

    public void play(Sample[] toPlay) {
        byte[] bToPlay = new byte[65536];
        for (int i = 0; i < 32768; i++) {
            bToPlay[2 * i] = toPlay[i].get();
            bToPlay[(2 * i) + 1] = toPlay[i].get();
        }
        play(bToPlay);
    }

    public void play(Sample toPlay) {
        play(new byte[] {toPlay.get(), toPlay.get()});
    }

    public void play(byte[] toPlay) {
        try {
            sourceDataLine.write(toPlay, 0, toPlay.length);
        } catch (Exception e) { System.err.println(e); }
    }


    public static void dotDisplay(byte[] toDisplay) {
        for (int i = 0; i < toDisplay.length; i+=4) {
            dotAt((int) toDisplay[i]); System.out.print("\n");
        }
    }

    public static void dotAt(int pos) {
        System.out.print(blank.substring(0, (pos + 129))  + "#" + pos);
    }

    public static void byteDisplay(byte[] toDisplay) {
        String thisByte;
        for (int i = 0; i < toDisplay.length; i+=2) {
            thisByte = "                ";
            thisByte += Integer.toBinaryString((int) /*Math.sqrt((double) */toDisplay[i]) + "  ";
            thisByte = thisByte.substring(thisByte.length()-12, thisByte.length());
            System.out.print(thisByte);
            if (i % 64 == 0) {
                dotAt(toDisplay[i]);
                System.out.print("\n");
            }
        }
    }


}
