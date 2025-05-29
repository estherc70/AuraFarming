import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SpacebarImageSwitcher extends JPanel {
    private ImageIcon[] images;
    private int currentIndex;

    public SpacebarImageSwitcher(String[] imagePaths, int width, int height) {
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(true);
        this.setLayout(null);
        setOpaque(false);

        images = new ImageIcon[imagePaths.length];
        for (int i = 0; i < imagePaths.length; i++) {
            images[i] = new ImageIcon(imagePaths[i]);
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

