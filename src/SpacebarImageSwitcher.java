import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpacebarImageSwitcher extends JPanel {
    private ImageIcon[] images;
    private int currentIndex;

    public SpacebarImageSwitcher(ArrayList<BufferedImage> imagePaths) {
        this.setFocusable(true);
        this.setLayout(null);
        setOpaque(false);

        images = new ImageIcon[imagePaths.size()];
        for (int i = 0; i < imagePaths.size(); i++) {
            images[i] = new ImageIcon(imagePaths.get(i));
        }

        currentIndex = 0;
        setupKeyBinding();
    }

    private void setupKeyBinding() {
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "nextImage");

        actionMap.put("nextImage", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % images.length;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (images[currentIndex] != null) {
            Image img = images[currentIndex].getImage();
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

