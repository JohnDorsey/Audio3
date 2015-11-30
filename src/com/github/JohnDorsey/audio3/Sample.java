/**
 * Created by John on 11/17/15.
 */

package com.github.JohnDorsey.audio3;

public class Sample {
    byte[] bytes = {(byte) 0, (byte) 0};

    public Sample(byte start, byte end) {
        bytes[0] = start; bytes[1] = end;
    }
    public Sample(byte[] nBytes) {
        bytes[0] = nBytes[0]; bytes[1] = nBytes[1];
    }

    public byte[] getBoth() {
        return bytes;
    }

    public byte get() {
        byte g = bytes[0];
        flip();
        return g;
    }

    public void flip() {
        byte fl = bytes[0];
        bytes[0] = bytes[1];
        bytes[1] = fl;
    }



}
