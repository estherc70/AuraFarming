import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Frame extends JFrame implements ActionListener {
    private JPanel mainPanel, livestreamScreen, mail2, loginInScreen, auraInfo, ticTacToe, gamesScreen, appScreen;
    private JScrollPane scrollPane;
    //private JLabel username;
    private ButtonClass buttonClass;
    private CardLayout cardLayout;
    private JPanelAnimation mailPanel;
    private Sponsors sponsors;
    private SpacebarImageSwitcher switcher;
    private SpacebarImageSwitcher switcher2;
    private Player player;

    public Frame() throws IOException {
        System.out.println("[DEBUG] Created switcher: " + switcher);
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        player = new Player();
        buttonClass = new ButtonClass(this,player);
        sponsors = new Sponsors();
        scrollPane = buttonClass.getScrollPane();

        JPanel startScreen = PanelClass.createPanel("src/images/enteruser.png");
        JPanel tutorialScreen = PanelClass.createPanel("src/images/tutorial.jpeg");
        JPanel backgroundScreen = PanelClass.createPanel("src/images/background.png");
        loginInScreen = PanelClass.createPanel("src/images/loginInScreen.png");
        appScreen = PanelClass.createPanel("src/images/appScreen.png");
        JPanel editAppScreen = PanelClass.createPanel("src/images/EditAppScreen.png");
        livestreamScreen = PanelClass.createPanel("src/images/livestreambg.png");
        JPanel mailScreen = PanelClass.createPanel("src/MailImages/mailhomepage.png");
        auraInfo = PanelClass.createPanel("src/images/tutorial.jpeg");
        JPanel gamesScreen = PanelClass.createPanel("src/images/GamesScreen.png");
        ticTacToe = PanelClass.createPanel("src/images/TicTacToe.png");
        JPanel ticTacToeWin = PanelClass.createPanel("src/images/TicTacToeWin.png");
        JPanel ticTacToeLose = PanelClass.createPanel("src/iamges/TicTacToeLose.png");
        JPanel ticTacToeNull = PanelClass.createPanel("src/images/TicTacToeNull.png");
        JPanel ticTacToeDraw = PanelClass.createPanel("src/images/TicTacToeDraw.png");
        JPanel rpsScreen = PanelClass.createPanel("src/images/RockPaperScissorsGame/startScreen.png");


//        try {
//            Font pressStartFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/PressStart2P-Regular.ttf"))
//                    .deriveFont(Font.PLAIN, 24f);
//            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//            ge.registerFont(pressStartFont);
//        } catch (FontFormatException | IOException e1) {
//            e1.printStackTrace();
//        }

//        username.setBounds(100,100,getWidth(),getHeight());
//        loginInScreen.add(username);

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
        BufferedImage img = ImageIO.read(new File("src/DesktopPetImages/Ivan1/ivan11.png"));
        animationFrames3.add(img);
        ArrayList<BufferedImage> animationFrames4 = new ArrayList<>();


        initailizeIvanImages(animationFrames,0,7,"Ivan1");
        initailizeIvanImages(animationFrames2,7,11,"Ivan1");
        initailizeIvanImages(animationFrames4,12,14,"Ivan1");

        JPanelAnimation startPanel = new JPanelAnimation(this, "StartScreen" ,startingImages, 300, 3);
        mainPanel.add(startPanel);

        ImageAnimation animation = new ImageAnimation(animationFrames, 300, 100, 200);
        tutorialScreen.add(animation.getAnimationPanel());

//        ArrayList<BufferedImage> animationFrames5 = new ArrayList<>();
//        BufferedImage img2 = ImageIO.read(new File("src/DesktopPetImages/Ivan/ivan14.png"));
//        animationFrames5.add(img2);

        ArrayList<BufferedImage> animationFrames5 = new ArrayList<>();
        initailizeIvanImages(animationFrames5,15,22,"Ivan2");

        ArrayList<BufferedImage> animationFrames6 = new ArrayList<>();
        BufferedImage img2 = ImageIO.read(new File("src/DesktopPetImages/Ivan1/ivan14.png"));
        animationFrames6.add(img2);

        ImageAnimation animation2 = new ImageAnimation(animationFrames5, 300,175,125);
        backgroundScreen.add(animation2.getAnimationPanel());

        ArrayList<BufferedImage> speechImages = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            String fileName = "src/DesktopPetImages/Speech/speech" + i + ".png";
            try {
                speechImages.add(ImageIO.read(new File(fileName)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> speechImages2 = new ArrayList<>();
        for (int i = 8; i < 12; i++) {
            String fileName = "src/DesktopPetImages/Speech2/speech" + i + ".png";
            try {
                speechImages2.add(ImageIO.read(new File(fileName)));
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
        switcher = new SpacebarImageSwitcher(speechImages);
        switcher.setBounds(360, 200, 200, 100);
        tutorialScreen.add(switcher);

        switcher.setDialogueChangeListener(pressCount -> {
            System.out.println("[DEBUG] DialogueChangeListener: pressCount = " + pressCount);

            if (pressCount == 1) {
                animation.updateFrames(animationFrames2);
            }

            if (pressCount == 4) {
                switcher.setSwitcherActive(false);
                System.out.println("[DEBUG] Disabled switcher at pressCount == 5");
            }

            if (pressCount >= 5) {
                if (pressCount == 5) {
                    animation.updateFrames(animationFrames3);
                }
                if (pressCount > 5) {
                    animation.updateFrames(animationFrames4);
                    System.out.println("[DEBUG] Disabled switcher at pressCount > 5");
                    if (pressCount > 7) {
                        showCard("Background");
                    }
                }
            }
        });

        switcher2 = new SpacebarImageSwitcher(speechImages2);
        switcher2.setBounds(450, 175, 200, 100);
        backgroundScreen.add(switcher2);

        switcher2.setDialogueChangeListener(pressCount -> {
            System.out.println("[DEBUG] DialogueChangeListener: pressCount2 = " + pressCount);
            if (pressCount == 3) {
                animation2.updateLocation(450, 265);
                animation2.updateFrames(animationFrames6);
                switcher2.setBounds(700, 275, 200, 100);
                switcher2.setSwitcherActive(false);
                System.out.println("[DEBUG] Disabled switcher at pressCount == 5");
            }
        });


        buttonClass.getBookBtn().addActionListener(e -> {
            switcher.setSwitcherActive(true);  // or switcher.setEnabled(true); if you didn't rename
            System.out.println("Book button clicked. Dialogue resumed.");
        });

//        JPanelAnimation mailScreenAnimation = new JPanelAnimation(this, "MailScreen", mailImages, 100, 6);
//        mainPanel.add(mailScreenAnimation, "MailScreenAnimation");

        //manually control button positions
        startScreen.setLayout(null);
        tutorialScreen.setLayout(null);
        backgroundScreen.setLayout(null);
        loginInScreen.setLayout(null);
        appScreen.setLayout(null);
        editAppScreen.setLayout(null);
        livestreamScreen.setLayout(null);
        mailScreen.setLayout(null);
        auraInfo.setLayout(null);
        gamesScreen.setLayout(null);
        rpsScreen.setLayout(null);
        ticTacToe.setLayout(null);
        ticTacToeLose.setLayout(null);
        ticTacToeDraw.setLayout(null);
        ticTacToeWin.setLayout(null);
        ticTacToeNull.setLayout(null);

        //add buttons
        startScreen.add(buttonClass.getUsernameText());
        tutorialScreen.add(buttonClass.getNextButton());
        tutorialScreen.add(buttonClass.getBookBtn());
        backgroundScreen.add(buttonClass.getPowerOn());
        loginInScreen.add(buttonClass.getPasswordText());
        appScreen.add(buttonClass.getLivestreamApp());
        appScreen.add(buttonClass.getMailApp());
        appScreen.add(buttonClass.getEditApp());
        appScreen.add(buttonClass.getGamesApp());
        appScreen.add(buttonClass.getShopApp());
        appScreen.add(buttonClass.getEndDay());
        gamesScreen.add(buttonClass.getTicTacToeApp());
        livestreamScreen.add(buttonClass.getScrollPane(), BorderLayout.CENTER);
        gamesScreen.add(buttonClass.getRpsGame());
        ticTacToe.add(buttonClass.getTic1());
        ticTacToe.add(buttonClass.getTic2());
        ticTacToe.add(buttonClass.getTic3());
        ticTacToe.add(buttonClass.getTic4());
        ticTacToe.add(buttonClass.getTic5());
        ticTacToe.add(buttonClass.getTic6());
        ticTacToe.add(buttonClass.getTic7());
        ticTacToe.add(buttonClass.getTic8());
        ticTacToe.add(buttonClass.getTic9());
        ticTacToe.add(buttonClass.getCheckWinner());

        mainPanel.add(startScreen, "StartScreen");
        mainPanel.add(tutorialScreen, "TutorialScreen");
        mainPanel.add(backgroundScreen, "Background");
        mainPanel.add(loginInScreen,"LoginInScreen");
        mainPanel.add(editAppScreen,"EditAppScreen");
        mainPanel.add(livestreamScreen, "LivestreamScreen");
        mainPanel.add(mailScreen, "MailScreen");
        mainPanel.add(appScreen, "AppScreen");
        mainPanel.add(auraInfo, "auraInfo");
        mainPanel.add(gamesScreen, "GamesScreen");
        mainPanel.add(ticTacToe, "TicTacToe");
        mainPanel.add(rpsScreen,"RockPaperScissors");
        mainPanel.add(ticTacToeDraw, "TicTacToeDraw");
        mainPanel.add(ticTacToeNull, "TicTacToeNull");
        mainPanel.add(ticTacToeWin, "TicTacToeWin");
        mainPanel.add(ticTacToeLose, "TicTacToeLose");

        livestreamScreen.add(scrollPane);

        ArrayList<BufferedImage> currentSponsor = sponsors.getRandomSponsors();
        ArrayList<Integer> usedSponsor = sponsors.getUsedSponsors();
        int y = 138;
        for (int i = 0; i < currentSponsor.size(); i++) {
            BufferedImage image = currentSponsor.get(i);
            ImageIcon icon = new ImageIcon(image);
            JButton button = new JButton();
            button.setIcon(icon);
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setBorderPainted(true);
            int num = usedSponsor.get(i);
            button.setActionCommand("sponsor" + num);
            button.addActionListener(this);
            mailScreen.add(button);
            button.setBounds(33, y, 938, 93);
            y += 82;
        }

//        System.out.println("Username: " + player.getUsername());
//        String inputUsername = buttonClass.getUsernameText().getText();
//        player.setUsername(inputUsername);
//        JLabel username = new JLabel(player.getUsername());
//        username.setFont(new Font("Arial", Font.BOLD, 24));
//        username.setForeground(Color.WHITE);
//        username.setBounds(100, 100, 300, 50);
//        loginInScreen.setLayout(null);
//        loginInScreen.add(username);

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

    public JPanel getAuraInfo() {
        return auraInfo;
    }

    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
    }


    public static Frame createFrame() throws IOException {
        return new Frame();
    }

    public JPanel getMailScreen() {
        return mainPanel;
    }

    public JPanel getLoginInScreen() {
        return loginInScreen;
    }



    private void initailizeIvanImages (ArrayList<BufferedImage> frames, int start, int end, String src) {
        for (int i = start; i < end; i++) {
            try {
                BufferedImage img = ImageIO.read(new File("src/DesktopPetImages/" + src + "/ivan" + i + ".png"));
                frames.add(img);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public JPanel getLivestreamScreen() {
        return livestreamScreen;
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String num = command.replaceAll("\\D+", "");
        String panelName = "mail" + num;

        // Only add if not already added
        if (!((CardLayout) mainPanel.getLayout()).toString().contains(panelName)) {
            JPanel mailPanel = PanelClass.createPanel("src/MailImages/mails/" + num + ".png");
            mailPanel.setLayout(null);
            mainPanel.add(mailPanel, panelName);
            buttonClass.getAccept().setBounds(400, 590, 150, 40);
            buttonClass.getDecline().setBounds(650,590, 150,40);
            if (buttonClass.getAccept().getParent() != null) {
                buttonClass.getAccept().getParent().remove(buttonClass.getAccept());
            }
            if (buttonClass.getDecline().getParent() != null) {
                buttonClass.getDecline().getParent().remove(buttonClass.getDecline());
            }
            mailPanel.add(buttonClass.getAccept());
            mailPanel.add(buttonClass.getDecline());
            mailPanel.revalidate();
            mailPanel.repaint();
        }

        showCard(panelName);
    }

    public JPanel getAppScreen() {
        return appScreen;
    }

    public JPanel getTicTacToe() {
        return ticTacToe;
    }
}
