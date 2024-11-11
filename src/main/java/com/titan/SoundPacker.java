package com.titan;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;


public class SoundPacker {

    public static void packSounds(List<String> wavFiles, String outputFilePath) throws IOException {
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(outputFilePath))) {
            outputStream.writeInt(wavFiles.size());

            for (String wavFile : wavFiles) {
                WavFile wav = new WavFile(wavFile);
                byte[] header = wav.getHeader();
                byte data = wav.getData();
                int sampleRate = wav.getSampleRate();
                int bitsPerSample = wav.getBitsPerSample();
                int numChannels = wav.getNumChannels();
                String fileName = new File(wavFile).getName();

                outputStream.writeInt(fileName.length());
                outputStream.writeBytes(fileName);

                outputStream.writeInt(header.length);
                outputStream.write(header);

                outputStream.writeInt(data);
                outputStream.write(data);

                outputStream.writeInt(sampleRate);
                outputStream.writeInt(bitsPerSample);
                outputStream.writeInt(numChannels);

                // Adding Class6 encoding

                // Adding Class39 encoding
                Class39 class39 = new Class39();
                class39.encodeToStream(outputStream);
                Class6 class6 = new Class6();
                Class29 class29 = new Class29();
                class29.method325(outputStream);
                class6.encodeToStream(outputStream);
                int[] encodedData = class6.method167(data, sampleRate);
                for (int value : encodedData) {
                    outputStream.writeInt(value);
                }
            }
        }
    }

    public static List<String> getWavFiles(String directoryPath) throws IOException {
        List<String> wavFiles = new ArrayList<>();
        Files.walk(Paths.get(directoryPath)).filter(Files::isRegularFile).forEach(path -> {
            if (path.toString().toLowerCase().endsWith(".wav")) {
                wavFiles.add(path.toString());
            }
        });
        return wavFiles;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java SoundPacker <output file> <directory path>");
            return;
        }

        String outputFilePath = args[0];
        String directoryPath = args[1];

        try {
            List<String> wavFiles = getWavFiles(directoryPath);
            if (wavFiles.isEmpty()) {
                System.out.println("No WAV files found in the specified directory.");
                return;
            }
            packSounds(wavFiles, outputFilePath);
            System.out.println("Packed sounds into " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
