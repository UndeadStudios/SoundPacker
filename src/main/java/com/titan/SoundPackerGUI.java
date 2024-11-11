package com.titan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SoundPackerGUI extends JFrame {
    private JTextField directoryPathField;
    private JTextField outputPathField;
    private JButton selectDirectoryButton;
    private JButton selectOutputButton;
    private JButton packButton;
    private JFileChooser fileChooser;

    public SoundPackerGUI() {
        setTitle("Sound Packer");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        directoryPathField = new JTextField(20);
        outputPathField = new JTextField(20);

        selectDirectoryButton = new JButton("Select Directory");
        selectOutputButton = new JButton("Select Output File");
        packButton = new JButton("Pack Sounds");

        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("WAV Directory:"), gbc);

        gbc.gridx = 1;
        add(directoryPathField, gbc);

        gbc.gridx = 2;
        add(selectDirectoryButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Output File:"), gbc);

        gbc.gridx = 1;
        add(outputPathField, gbc);

        gbc.gridx = 2;
        add(selectOutputButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(packButton, gbc);

        selectDirectoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = fileChooser.showOpenDialog(SoundPackerGUI.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedDirectory = fileChooser.getSelectedFile();
                    directoryPathField.setText(selectedDirectory.getAbsolutePath());
                }
            }
        });

        selectOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int result = fileChooser.showSaveDialog(SoundPackerGUI.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    outputPathField.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        packButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String directoryPath = directoryPathField.getText();
                String outputPath = outputPathField.getText();
                if (directoryPath.isEmpty() || outputPath.isEmpty()) {
                    JOptionPane.showMessageDialog(SoundPackerGUI.this, "Please select both directory and output file.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    List<String> wavFiles = SoundPacker.getWavFiles(directoryPath);
                    if (wavFiles.isEmpty()) {
                        JOptionPane.showMessageDialog(SoundPackerGUI.this, "No WAV files found in the specified directory.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    SoundPacker.packSounds(wavFiles, outputPath);
                    JOptionPane.showMessageDialog(SoundPackerGUI.this, "Packed sounds into " + outputPath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(SoundPackerGUI.this, "An error occurred while packing sounds.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SoundPackerGUI().setVisible(true);
            }
        });
    }
}
