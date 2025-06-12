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
        else if (fileName.equals("src/shopimages/shop2.png")) {
            //cardLayoutPanel.getShop().removeAll();
            buttonClass.getHundredAura().setLocation(68, 500);
            buttonClass.getThousandAura().setLocation(365, 500);
            buttonClass.getTwoThousandAura().setLocation(675, 500);
            buttonClass.getHundredAura().setSize(240, 50);
            buttonClass.getThousandAura().setSize(240, 50);
            buttonClass.getTwoThousandAura().setSize(240, 50);
            //cardLayoutPanel.getShop().add(buttonClass.getAura());

        }
        else if (fileName.equals("src/shopimages/areyousure.png")) {
            buttonClass.getYes().setLocation(155, 380);
            buttonClass.getNo().setLocation(530, 380);
            buttonClass.getYes().setSize(250, 50);
            buttonClass.getNo().setSize(250, 50);

        }

        // Scale the image to fit the size of the panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public static JPanel createPanel(String fileName, ButtonClass buttonClass, Frame cardLayoutPanel) {
        return new PanelClass(fileName, buttonClass, cardLayoutPanel);
    }
}
