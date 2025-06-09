import javax.swing.*;
import java.awt.*;

public class PanelClass extends JPanel {
    private String fileName;
    private ButtonClass buttonClass;

    public PanelClass(String fileName, ButtonClass buttonClass) {
        this.fileName = fileName;
        this.buttonClass = buttonClass;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Load the background image
        ImageIcon backgroundIcon = new ImageIcon(fileName);
        Image backgroundImage = backgroundIcon.getImage();
        if (fileName.equals("src/shopimages/shop.png")) {
            buttonClass.getShop().setSize(200, 70);
            buttonClass.getShop().setLocation(400, 400);
        }

        // Scale the image to fit the size of the panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public static JPanel createPanel(String fileName, ButtonClass buttonClass) {
        return new PanelClass(fileName, buttonClass);
    }
}
