import javax.swing.*;

public class Frame {
    public Frame() {
        JFrame frame = new JFrame("Frame title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);

        DisplayPanel panel = new DisplayPanel();
        frame.add(panel);

        frame.setResizable(false);
        frame.setVisible(true);
    }
}
