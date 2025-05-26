import javax.swing.*;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DisplayPanel extends JPanel implements ActionListener {
    private JButton button;
    private JButton anotherButton;
    private JTextField textField;
    private Timer timer;
    private BufferedImage goomba;
    private String message;
    private boolean toggle;
    private int goombaX;

    public DisplayPanel() {
        toggle = false;
        goombaX = 200;
        message = "This is the display panel!";
        button = new JButton("Click me");
        timer = new Timer(10, this);
        timer.start();
        button.addActionListener(this);
        add(button);

        anotherButton = new JButton("Surprise");
        anotherButton.addActionListener(this);
        add(anotherButton);

        textField = new JTextField(15);
        add(textField);

        try {
            goomba = ImageIO.read(new File("src/images/goomba.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        if (toggle) {
            g.setColor(Color.GREEN);
            g.drawRect(45, 10, 200, 30);
            g.setColor(Color.BLUE);
        } else {
            g.setColor(Color.RED);
        }
        g.drawString(message, 50, 30);
        g.drawImage(goomba, goombaX, 125, null);
        button.setLocation(50, 100);
        anotherButton.setLocation(150, 100);
        textField.setLocation(50, 60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object sender = e.getSource();
        if (sender == button) {
            message = textField.getText();
            textField.setText("");
        } else if (sender == anotherButton) {
            toggle = !toggle;
        } else if (sender == timer) {
            goombaX += 1;
            if (goombaX > 300) {
                goombaX = 0;
            }
        }
        repaint();
    }
}