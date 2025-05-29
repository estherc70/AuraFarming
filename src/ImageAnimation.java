import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageAnimation implements ActionListener {
    private ArrayList<BufferedImage> frames;
    private Timer timer;
    private int currentFrame;
    private int loopCount;
    private int maxLoops;
    private JPanel animationPanel;

    public ImageAnimation(ArrayList<BufferedImage> frames, int delay, int maxLoops) {
        this.frames = frames;
        this.maxLoops = maxLoops;
        currentFrame = 0;
        loopCount = 0;

        animationPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage frame = getActiveFrame();
                if (frame != null) {
                    g.drawImage(frame, 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        animationPanel.setOpaque(false);
        animationPanel.setBounds(100, 200, 300, 300);

        timer = new Timer(delay, this);
        timer.start();

        new Timer(delay, e -> animationPanel.repaint()).start();
    }

    public BufferedImage getActiveFrame() {
        return frames.get(currentFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame++;
        if (currentFrame >= frames.size()) {
            currentFrame = 0;
            loopCount++;
            if (loopCount >= maxLoops) {
                timer.stop();
            }
        }
    }

    public JPanel getAnimationPanel() {
        return animationPanel;
    }
}

