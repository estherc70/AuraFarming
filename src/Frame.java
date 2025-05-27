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
        for (int i = 1; i <= 5; i++) {
            String fileName = "src/images/Staring (" + i + ").PNG";
            try {
                startingImages.add(ImageIO.read(new File(fileName)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        JPanelAnimation startPanel = new JPanelAnimation(this, "StartScreen" ,startingImages, 300, 3);
        mainPanel.add(startPanel);

        //create card panels
        JPanel startScreen = PanelClass.createPanel("src/images/start.png");
        JPanel backgroundScreen = PanelClass.createPanel("src/images/background.png");
        JPanel livestreamScreen = PanelClass.createPanel("src/images/livestreambg.png");

        //manually control button positions
        startScreen.setLayout(null);
        backgroundScreen.setLayout(null);
        livestreamScreen.setLayout(null);

        //add buttons
        startScreen.add(buttonClass.getUsernameText());
        backgroundScreen.add(buttonClass.getLivestreamApp());
        livestreamScreen.add(buttonClass.getLivestreamChat());

        mainPanel.add(startScreen, "StartScreen");
        mainPanel.add(backgroundScreen, "Background");
        mainPanel.add(livestreamScreen, "LivestreamScreen");

        Container pane = getContentPane();
        pane.add(mainPanel, BorderLayout.CENTER);
        pane.add(buttonClass.getBtnPanel(), BorderLayout.SOUTH);

        setTitle("Aura Farming Simulator");
        setSize(1000, 700); // Set the size of the window
        setResizable(false); // Disable resizing the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);

        //create custom cursor
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/images/cursor.png");
        Point hotSpot = new Point(0, 0);

        Cursor customCursor = toolkit.createCustomCursor(image, hotSpot, "MyCursor");
        mainPanel.setCursor(customCursor);
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
