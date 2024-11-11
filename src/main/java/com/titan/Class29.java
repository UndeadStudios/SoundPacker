package com.titan;

import java.io.DataOutputStream;
import java.io.IOException;

public class Class29 {
    int anInt538;
    int anInt539;
    int anInt540;

    public void method325(Stream stream) {
        anInt538 = stream.readSmart();
        anInt539 = stream.readSmart();
        anInt540 = stream.readSmart();
    }

    public void resetValues() {
        anInt538 = 0;
        anInt539 = 0;
        anInt540 = 0;
    }

    public int method328(int i) {
        return (int) (Math.random() * (anInt539 - anInt538 + 1)) + anInt538;
    }

    public void encodeToStream(DataOutputStream outputStream) throws IOException {
        outputStream.writeInt(anInt538);
        outputStream.writeInt(anInt539);
        outputStream.writeInt(anInt540);
    }
}
