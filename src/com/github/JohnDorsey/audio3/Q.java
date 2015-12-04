package com.github.JohnDorsey.audio3;

/**
 * Created by John on 11/30/15.
 */
public class Q {

    public int length = 512;
    public int start = 0;
    public int travel = 0;
    public Sample[] content = new Sample[length];

    public Q() {
        for (int i = 0; i < length; i++) {
            content[i] = new Sample((byte) 0, (byte) 0);
        }
    }

    public void add(Sample toAdd) {
        //System.out.println("add - s" + start + " t" + travel);
        content[(start + travel) % length] = toAdd;
        travel++;
    }

    public boolean canAdd() {
        if (travel >= length) { /*System.out.println("Q.add: FULL");*/ return false; } else { /*System.out.println("Q.add: not full");*/ }
        return true;
    }

    public Sample read() {
        //System.out.println("read - s" + start + " t" + travel);
        Sample result = content[start];
        start = (start + 1) % length;
        travel = Math.max(travel - 1, 0);
        return result;
    }


}
