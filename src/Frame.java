import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Frame extends JFrame{
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    private ButtonClass buttonClass;
    private CardLayout cardLayout;
    private ImageAnimation desktopPet;
    private JPanelAnimation mailPanel;
    private Sponsors sponsors;

    public Frame() throws IOException {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        buttonClass = new ButtonClass(this);
        sponsors = new Sponsors();
        //desktopPet = new ImageAnimation();
        scrollPane = buttonClass.getScrollPane();

        //create card panels

        JPanel startScreen = PanelClass.createPanel("src/images/enteruser.png");
        JPanel tutorialScreen = PanelClass.createPanel("src/images/tutorial.jpeg");
        JPanel backgroundScreen = PanelClass.createPanel("src/images/background.png");
        JPanel livestreamScreen = PanelClass.createPanel("src/images/livestreambg.png");
        JPanel mailScreen = PanelClass.createPanel("src/MailImages/mailhomepage.png");

        ImageIcon tutorialImageIcon = new ImageIcon("src/DesktopPetImages/book.png");
        JLabel tutorialLabel = new JLabel(tutorialImageIcon);
        tutorialLabel.setBounds(0, 0, tutorialImageIcon.getIconWidth(), tutorialImageIcon.getIconHeight());
        tutorialScreen.add(tutorialLabel);


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
        ArrayList<BufferedImage> animationFrames2 = new ArrayList<>();
        ArrayList<BufferedImage> animationFrames3 = new ArrayList<>();
        BufferedImage img = ImageIO.read(new File("src/DesktopPetImages/Ivan/ivan11.png"));
        animationFrames3.add(img);

        initailizeIvanImages(animationFrames,0,7);
        initailizeIvanImages(animationFrames2,7,11);

//        for (int i = 0; i < 7; i++) {
//            try {
//                BufferedImage img = ImageIO.read(new File("src/DesktopPetImages/Ivan/ivan" + i + ".png"));
//                animationFrames.add(img);
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//
//        for (int i = 7; i < 11; i++) {
//            try {
//                BufferedImage img = ImageIO.read(new File("src/DesktopPetImages/Ivan/ivan" + i + ".png"));
//                animationFrames2.add(img);
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }

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

        ImageAnimation animation = new ImageAnimation(animationFrames, 300);
        tutorialScreen.add(animation.getAnimationPanel());

        ArrayList<BufferedImage> speechImages = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            String fileName = "src/DesktopPetImages/Speech/speech" + i + ".png";
            try {
                speechImages.add(ImageIO.read(new File(fileName)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        /*String[] paths = {
                "src/DesktopPetImages/Speech/speech0.png",
                "src/DesktopPetImages/Speech/speech1.png",
                "src/DesktopPetImages/Speech/speech2.png",
                "src/DesktopPetImages/Speech/speech3.png"
        };*/
        SpacebarImageSwitcher switcher = new SpacebarImageSwitcher(speechImages);
        switcher.setBounds(360, 200, 200, 100);
        tutorialScreen.add(switcher);

        switcher.setDialogueChangeListener(pressCount -> {
            if (pressCount == 1) {
                animation.updateFrames(animationFrames2);
            }

            if (pressCount > 5) {
                switcher.setEnabled(false);
                System.out.println("Max dialogue presses reached");
            }
        });

//        JPanelAnimation mailScreenAnimation = new JPanelAnimation(this, "MailScreen", mailImages, 100, 6);
//        mainPanel.add(mailScreenAnimation, "MailScreenAnimation");

        //manually control button positions
        startScreen.setLayout(null);
        tutorialScreen.setLayout(null);
        backgroundScreen.setLayout(null);
        livestreamScreen.setLayout(null);
        mailScreen.setLayout(null);

        //add buttons
        startScreen.add(buttonClass.getUsernameText());
        tutorialScreen.add(buttonClass.getNextButton());
        tutorialScreen.add(buttonClass.getBookBtn());
        backgroundScreen.add(buttonClass.getLivestreamApp());
        backgroundScreen.add(buttonClass.getMailApp());
        backgroundScreen.add(buttonClass.getEditApp());
        livestreamScreen.add(buttonClass.getScrollPane(), BorderLayout.CENTER);
        livestreamScreen.add(buttonClass.getHomePage());
        mailScreen.add(buttonClass.getHomePage());
        livestreamScreen.add(buttonClass.getHomePage());

        mainPanel.add(startScreen, "StartScreen");
        mainPanel.add(tutorialScreen, "TutorialScreen");
        mainPanel.add(backgroundScreen, "Background");
        mainPanel.add(livestreamScreen, "LivestreamScreen");
        mainPanel.add(mailScreen, "MailScreen");

        livestreamScreen.add(scrollPane);

        ArrayList<BufferedImage> currentSponsor = sponsors.getRandomSponsors();
        int y = 50;
        for (int i = 0; i < currentSponsor.size(); i++) {
            BufferedImage image = currentSponsor.get(i);
            ImageIcon icon = new ImageIcon(image);
            JButton button = new JButton();
            button.setIcon(icon);
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setBorderPainted(true);
            mailScreen.add(button);
            button.setBounds(10, y, 1498, 168);
            y += 30;
        }

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


    public static Frame createFrame() throws IOException {
        return new Frame();
    }

    public JPanel getMailScreen() {
        return mainPanel;
    }

    private void initailizeIvanImages (ArrayList<BufferedImage> frames, int start, int end) {
        for (int i = start; i < end; i++) {
            try {
                BufferedImage img = ImageIO.read(new File("src/DesktopPetImages/Ivan/ivan" + i + ".png"));
                frames.add(img);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
