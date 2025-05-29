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
    private ImageAnimation desktopPet;
    private JPanelAnimation mailPanel;

    public Frame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        buttonClass = new ButtonClass(this);
        //desktopPet = new ImageAnimation();

        //loading screen animation
        ArrayList<BufferedImage> startingImages = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String fileName = "src/images/starting" + i + ".png";
            try {
                startingImages.add(ImageIO.read(new File(fileName)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> animationFrames = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            try {
                BufferedImage img = ImageIO.read(new File("src/DesktopPetImages/ivan" + i + ".png"));
                animationFrames.add(img);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

//        ArrayList<BufferedImage> mailImages = new ArrayList<>();
//        for (int i = 1; i < 15; i++) {
//            try {
//                String file = "src/MailImages/" + i + ".png";
//                BufferedImage mailImg = ImageIO.read(new File(file));
//                mailImages.add(mailImg);
//            }
//            catch (IOException exception) {
//                System.out.println(exception.getMessage());
//            }
//        }



        JPanelAnimation startPanel = new JPanelAnimation(this, "StartScreen" ,startingImages, 300, 3);
        mainPanel.add(startPanel);






        //create card panels
        JPanel startScreen = PanelClass.createPanel("src/images/enteruser.png");
        JPanel tutorialScreen = PanelClass.createPanel("src/images/tutorial.jpeg");
        JPanel backgroundScreen = PanelClass.createPanel("src/images/background.png");
        JPanel livestreamScreen = PanelClass.createPanel("src/images/livestreambg.png");
        JPanel mailScreen = PanelClass.createPanel("src/MailImages/1.png");




        ImageAnimation animation = new ImageAnimation(animationFrames, 300);
        tutorialScreen.add(animation.getAnimationPanel());


        //manually control button positions
        startScreen.setLayout(null);
        tutorialScreen.setLayout(null);
        backgroundScreen.setLayout(null);
        livestreamScreen.setLayout(null);
        //mailScreenAnimation.setLayout(null);
        mailScreen.setLayout(null);

        //add buttons
        startScreen.add(buttonClass.getUsernameText());
        tutorialScreen.add(buttonClass.getNextButton());
        backgroundScreen.add(buttonClass.getLivestreamApp());
        backgroundScreen.add(buttonClass.getMailApp());
        livestreamScreen.add(buttonClass.getLivestreamChat());






        mainPanel.add(startScreen, "StartScreen");
        mainPanel.add(tutorialScreen, "TutorialScreen");
        mainPanel.add(backgroundScreen, "Background");
        mainPanel.add(livestreamScreen, "LivestreamScreen");
        //mainPanel.add(mailScreenAnimation, "MailScreenAnimation");
        mainPanel.add(mailScreen, "MailScreen");




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

    public JPanel getMailScreen() {
        return mainPanel;
    }
}
