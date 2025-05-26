import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    private JPanel mainPanel;
    private ButtonClass buttonClass;
    private CardLayout cardLayout;

    public Frame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        buttonClass = new ButtonClass(this);

        JPanel startScreen = PanelClass.createPanel("src/images/start.png");

        //manually control button positions
        startScreen.setLayout(null);

        startScreen.add(buttonClass.getStartbtn());

        mainPanel.add(startScreen, "StartScreen");

        Container pane = getContentPane();
        pane.add(mainPanel, BorderLayout.CENTER);
        pane.add(buttonClass.getBtnPanel(), BorderLayout.SOUTH);

        setTitle("CardLayoutOrganized");
        setSize(1000, 700); // Set the size of the window
        setResizable(false); // Disable resizing the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    //switch through card panels ((used in ButtonPanel for ActionListeners)
    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
    }

    public static Frame createFrame() {
        return new Frame();
    }
}
