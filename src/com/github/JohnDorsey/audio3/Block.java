package com.github.JohnDorsey.audio3;

/**
 * Created by John on 12/8/15.
 */
public class Block {

    public byte type;
    public short length;
    public byte[] content;

    public Block(byte nType, short nLength, byte[] nContent) {
        type = nType; length = nLength; content = nContent;
    }

}
