import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TimerCardExample extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JPanel timerPanel;
    private JPanel otherPanel;

    private Timer timer;
    private int counter = 0;
    private JLabel counterLabel;

    public TimerCardExample() {
        // Set up layout
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Panel with timer
        timerPanel = new JPanel();
        counterLabel = new JLabel("Counter: 0");
        JButton toOtherButton = new JButton("Go to Other Panel");
        timerPanel.add(counterLabel);
        timerPanel.add(toOtherButton);

        // Other panel
        otherPanel = new JPanel();
        otherPanel.add(new JLabel("Other Panel"));
        JButton toTimerButton = new JButton("Back to Timer Panel");
        otherPanel.add(toTimerButton);

        // Add panels to card layout
        cardPanel.add(timerPanel, "TimerPanel");
        cardPanel.add(otherPanel, "OtherPanel");

        // Add to frame
        add(cardPanel);

        // Timer: increments counter every 5 seconds
        timer = new Timer(5000, e -> {
            int rand = (int)(Math.random() * 10 + 1);
            counter += rand;
            counterLabel.setText("Counter: " + counter);
        });

        // Button actions
        toOtherButton.addActionListener(e -> {
            timer.stop(); // ✅ Stop timer when leaving
            cardLayout.show(cardPanel, "OtherPanel");
        });

        toTimerButton.addActionListener(e -> {
            timer.start(); // ✅ Start timer when entering
            cardLayout.show(cardPanel, "TimerPanel");
        });

        // Frame settings
        setTitle("CardLayout with Timer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);

        // Start with the timer panel and timer
        cardLayout.show(cardPanel, "TimerPanel");
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TimerCardExample::new);
    }
}
