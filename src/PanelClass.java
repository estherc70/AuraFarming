import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelClass extends JPanel {
    private String fileName;
    private ButtonClass buttonClass;
    private Frame cardLayoutPanel;

    public PanelClass(String fileName, ButtonClass buttonClass, Frame cardLayoutPanel) {
        this.fileName = fileName;
        this.buttonClass = buttonClass;
        this.cardLayoutPanel = cardLayoutPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Load the background image
        ImageIcon backgroundIcon = new ImageIcon(fileName);
        Image backgroundImage = backgroundIcon.getImage();
        if (fileName.equals("src/shopimages/shop.png")) {
            buttonClass.getShop().setSize(300, 70);
            buttonClass.getShop().setLocation(497, 255);
        }
        else if (fileName.equals("src/images/auraInfo.png")) {
            cardLayoutPanel.getAuraInfo().removeAll();
            cardLayoutPanel.getAuraInfo().add(buttonClass.getLabel());
            //cardLayoutPanel.getAuraInfo().repaint();
            //cardLayoutPanel.getAuraInfo().revalidate();
        }

        // Scale the image to fit the size of the panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public static JPanel createPanel(String fileName, ButtonClass buttonClass, Frame cardLayoutPanel) {
        return new PanelClass(fileName, buttonClass, cardLayoutPanel);
    }
}
