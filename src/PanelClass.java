import javax.swing.*;
import java.awt.*;

public class PanelClass extends JPanel {
    private String fileName;

    public PanelClass(String fileName) {
        this.fileName = fileName;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Load the background image
        ImageIcon backgroundIcon = new ImageIcon(fileName);
        Image backgroundImage = backgroundIcon.getImage();

        // Scale the image to fit the size of the panel
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    public static JPanel createPanel(String fileName) {
        return new PanelClass(fileName);
    }
}
