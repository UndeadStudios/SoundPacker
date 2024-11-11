package com.titan;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Paths;

class WavFile {
    private String filePath;
    private byte[] header;
    private byte data;
    private int sampleRate;
    private int bitsPerSample;
    private int numChannels;

    public WavFile(String filePath) throws IOException {
        this.filePath = filePath;
        parseWavFile();
    }

    private void parseWavFile() throws IOException {
        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            header = new byte[44];
            inputStream.read(header, 0, 44);

            ByteBuffer buffer = ByteBuffer.wrap(header).order(ByteOrder.LITTLE_ENDIAN);
            buffer.position(24);
            sampleRate = buffer.getInt();
            buffer.position(34);
            bitsPerSample = buffer.getShort();
            numChannels = buffer.getShort(22);

            data = buffer.get();
        }
    }

    public byte[] getHeader() {
        return header;
    }

    public byte getData() {
        return data;
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public int getBitsPerSample() {
        return bitsPerSample;
    }

    public int getNumChannels() {
        return numChannels;
    }

    public String getFilePath() {
        return filePath;
    }
}
