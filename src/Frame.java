import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Frame extends JFrame{
    private JPanel mainPanel;
    private ButtonClass buttonClass;
    private CardLayout cardLayout;

    public Frame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        buttonClass = new ButtonClass(this);

        //loading screen animation
        ArrayList<BufferedImage> startingImages = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String fileName = "src/images/starting" + i + ".PNG";
            try {
                startingImages.add(ImageIO.read(new File(fileName)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        JPanelAnimation panel = new JPanelAnimation(this, "StartScreen" ,startingImages, 300, 3);
        mainPanel.add(panel);

        //create card panels
        JPanel startScreen = PanelClass.createPanel("src/images/start.png");

        //manually control button positions
        startScreen.setLayout(null);

        //add buttons
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
