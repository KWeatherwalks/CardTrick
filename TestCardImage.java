import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestCardImage extends JFrame {
    private JPanel imagePanel;
    private JLabel imageLabel;

    public TestCardImage() {
        setTitle("My Card");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        buildImagePanel();

        add(imagePanel, BorderLayout.CENTER);

        pack();
        setVisible(true);

    }

    private void buildImagePanel() {
        imagePanel = new JPanel();

        imageLabel = new JLabel("This is your card");

        imagePanel.add(imageLabel);

        ImageIcon cardImage = new ImageIcon("2_Diamonds.png");

        imageLabel.setIcon(cardImage);
    }

    public static void main(String[] args) {
        new TestCardImage();
    }
}