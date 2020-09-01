package com.kevinweatherwalks.cardtrick.userinterface;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 3373210803295297658L;
    private JPanel imagePanel;
    private JLabel imageLabel;

    public Test() throws IOException {
        setTitle("My Card");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buildImagePanel();

        add(imagePanel, BorderLayout.CENTER);

        pack();
        setVisible(true);

    }

    private void buildImagePanel() throws IOException {
        imagePanel = new JPanel();

        imageLabel = new JLabel("This is your card");

        imagePanel.add(imageLabel);

        BufferedImage img = ImageIO.read(this.getClass().getResource("/classiccards/2_Diamonds.png"));

        ImageIcon cardImage = new ImageIcon(img);

        imageLabel.setIcon(cardImage);
    }

    public static void main(String[] args) throws IOException {
        new Test();
    }
}