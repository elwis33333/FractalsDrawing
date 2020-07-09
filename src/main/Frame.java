package main;

import javax.swing.*;
import java.awt.*;

public class Frame extends Canvas {
    private static final long serialVersionUID = 1L;
    private JFrame frame;

    public Frame(String title) {
        GraphicsDevice[] ged = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

        frame = new JFrame(title);
        if(ged.length > 1)
            frame.setLocation(ged[1].getDefaultConfiguration().getBounds().getLocation());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(1000,1000));
        frame.setMaximumSize(new Dimension(1000,1000));
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setVisible(true);

        this.setSize(frame.getSize());

        frame.add(this);
    }
}