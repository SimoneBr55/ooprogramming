package org.nbicocchi.swing;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Notepad extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private final JTextArea textArea;
    private final JMenuItem openFile;
    private final JMenuItem saveFile;
    private final JMenuItem close;

    public Notepad() {
        super("Yet Another Java Notepad");

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        menuBar.add(file);

        openFile = new JMenuItem("Open...");
        openFile.addActionListener(this);
        file.add(openFile);

        saveFile = new JMenuItem("Save...");
        saveFile.addActionListener(this);
        file.add(saveFile);

        close = new JMenuItem("Close");
        close.addActionListener(this);
        file.add(close);

        textArea = new JTextArea("");

        setContentPane(new JScrollPane(textArea));
        setJMenuBar(menuBar);

        setSize(640, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.close) {
            dispose();
        } else if (e.getSource() == this.openFile) {
            JFileChooser open = new JFileChooser();
            int option = open.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                textArea.setText("");
                try {
                    String line;
                    BufferedReader in = new BufferedReader(new FileReader(open.getSelectedFile().getPath()));
                    while ((line = in.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    in.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Read failed!", "Failure!", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
            }
        } else if (e.getSource() == this.saveFile) {
            JFileChooser save = new JFileChooser();
            int option = save.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
                    out.write(textArea.getText());
                    out.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Write failed!", "Failure!", JOptionPane.ERROR_MESSAGE);
                    dispose();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        SwingUtilities.invokeLater(Notepad::new);
    }
}
