package org.nbicocchi.swing.pong;

import javax.swing.*;
import java.awt.*;

public class TestApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pong");

        PongPanel pong = new PongPanel();
        frame.setContentPane(pong);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        pong.init();
    }
}
