import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ButtonClass {
    private Player player;
    private JButton livestreamApp, nextButton, mailApp, bookBtn,
            editApp, powerOn, shopApp, gamesApp, endDay, accept,
            decline, next, ticTacToeApp, rpsGame, singleBtn, doubleBtn, backBtn, shop;
    private JButton tic1,tic2, tic3, tic4, tic5, tic6, tic7, tic8, tic9, checkWinner;
    private JTextArea livestreamChat;
    private JScrollPane scrollPane;
    private JTextField usernameText, passwordText;
    private JPanel btnPanel, mainPanel;
    private Frame cardLayoutPanel;
    private JPanelAnimation animation;
    private Livestream livestream;
    private Sponsors sponsors;
    private boolean livestreamExited;
    private Font pressStartFont;
    private TicTacToe ticTacToe;
    private JLabel TTTWin, TTTLose, TTTDraw, TTTNull;
    private boolean[] pressedKeys;


    public ButtonClass(Frame cardLayoutPanel,Player player, JPanel mainPanel)  {
        livestream = new Livestream();
        this.mainPanel = mainPanel;
        btnPanel = new JPanel(new BorderLayout());
        this.cardLayoutPanel = cardLayoutPanel;
        this.player = player;
        sponsors = new Sponsors();
        livestreamExited = false;
        ticTacToe = new TicTacToe();

        //create buttons
        usernameText = new JTextField(15);
        passwordText = new JTextField(4);
        livestreamChat = new JTextArea(280,500);
        scrollPane = new JScrollPane(livestreamChat);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(604, 105, 180, 335);

        livestreamApp = new JButton();
        nextButton = new JButton();
        mailApp = new JButton();
        bookBtn = new JButton();
        accept = new JButton();
        decline = new JButton();
        next = new JButton();
        bookBtn.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("SPACE"), "none");
        nextButton.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("SPACE"), "none");
        //testing
        editApp = new JButton();
        powerOn = new JButton();
        shopApp = new JButton();
        gamesApp = new JButton();
        endDay = new JButton();
        shop = new JButton();
        ticTacToeApp = new JButton();
        tic1 = ticTacToe.getButton(0);
        tic2 = ticTacToe.getButton(1);
        tic3 = ticTacToe.getButton(2);
        tic4 = ticTacToe.getButton(3);
        tic5 = ticTacToe.getButton(4);
        tic6 = ticTacToe.getButton(5);
        tic7 = ticTacToe.getButton(6);
        tic8 = ticTacToe.getButton(7);
        tic9 = ticTacToe.getButton(8);
        TTTWin = new JLabel(new ImageIcon("src/images/TicTacToeWin.png"));
        TTTLose = new JLabel(new ImageIcon("src/images/TicTacToeLose.png"));
        TTTDraw = new JLabel(new ImageIcon("src/images/TicTacToeDraw.png"));
        TTTNull = new JLabel(new ImageIcon("src/images/TicTacToeNull.png"));
        checkWinner = new JButton();
        rpsGame = new JButton();
        singleBtn = new JButton();
        doubleBtn = new JButton();
        backBtn = new JButton();

        try {
            pressStartFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/PressStart2P-Regular.ttf"))
                    .deriveFont(Font.PLAIN, 24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pressStartFont);
        } catch (FontFormatException | IOException e1) {
            e1.printStackTrace();
        }

        ImageIcon acceptIcon = new ImageIcon();
        ImageIcon declineIcon = new ImageIcon();
        ImageIcon nextIcon = new ImageIcon();
        try {
            BufferedImage acceptImage = ImageIO.read(new File("src/MailImages/mails/accept.png"));
            BufferedImage declineImage = ImageIO.read(new File("src/MailImages/mails/decline.png"));
            BufferedImage nextImage = ImageIO.read(new File("src/MailImages/next.png"));
            nextIcon = new ImageIcon(nextImage);
            acceptIcon = new ImageIcon(acceptImage);
            declineIcon = new ImageIcon(declineImage);
            //assert false;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        setButtonOpaque(next);
        next.setBounds(350, 400, 400, 100);

        accept.setIcon(acceptIcon);
        decline.setIcon(declineIcon);
        next.setIcon(nextIcon);

        //set opaque
        //customizeButton(livestreamApp);

        setButtonOpaque(nextButton);

        //customizeButton(mailApp);

        setButtonOpaque(editApp);

        setButtonOpaque(gamesApp);

        setButtonOpaque(shopApp);

        setButtonOpaque(endDay);

        setButtonOpaque(bookBtn);

        setButtonOpaque(accept);

        setButtonOpaque(decline);


        setButtonOpaque(ticTacToeApp);

        setButtonOpaque(rpsGame);

        setButtonOpaque(singleBtn);

        setButtonOpaque(doubleBtn);

        //testing
        customizeButton(powerOn);

        customizeButton(tic1);

        customizeButton(tic2);

        customizeButton(tic3);

        customizeButton(tic4);

        customizeButton(tic5);

        customizeButton(tic6);

        customizeButton(tic7);

        customizeButton(tic8);

        customizeButton(tic9);

        customizeButton(checkWinner);

//        powerOn.setOpaque(true);
//        powerOn.setContentAreaFilled(true);
//        powerOn.setBorderPainted(true);

        livestreamChat.setEditable(true);
        livestreamChat.setLineWrap(true);


        //set text field fonts
        //usernameText.setFont(new Font("Serif", Font.BOLD, 60));
//        usernameText.setFont(pressStartFont);
        usernameText.setFont(pressStartFont.deriveFont(45f));
        passwordText.setFont(pressStartFont);
//        passwordText.setFont(new Font("Serif", Font.BOLD, 60));
        livestreamApp.setFont(new Font("Serif", Font.ITALIC, 15));

        //set button/text field size
        usernameText.setBounds(150,360,700,75);
        passwordText.setBounds(505,298,135,30);
        mailApp.setBounds(323, 220, 65, 65);
        livestreamApp.setBounds(460,220,65,65);
        gamesApp.setBounds(600,220,65,65);
        editApp.setBounds(323, 345, 65, 65);
        shopApp.setBounds(460,345,65,65);
        endDay.setBounds(600,345,65,65);
        nextButton.setBounds(515,165,90,90);
        bookBtn.setBounds(625, 285, 145, 125);
        powerOn.setBounds(680,455,80,18);
        ticTacToeApp.setBounds(380,275,65,65);
        rpsGame.setBounds(520,275,65,65);
        tic1.setBounds(240,160,87,85);
        tic2.setBounds(332,160,87,85);
        tic3.setBounds(425,160,87,85);
        tic4.setBounds(240,250,87,85);
        tic5.setBounds(332,250,87,85);
        tic6.setBounds(425,250,87,85);
        tic7.setBounds(240,335,87,85);
        tic8.setBounds(332,335,87,85);
        tic9.setBounds(425,335,87,85);
        checkWinner.setBounds(585,273,150,40);
        singleBtn.setBounds(395,265,205,75);
        doubleBtn.setBounds(395,360,205,75);


        //livestreamApp.setVisible(false);

        btnPanel.add(usernameText);
        btnPanel.add(passwordText);
        btnPanel.add(livestreamApp);
        btnPanel.add(nextButton);
        btnPanel.add(mailApp);
        btnPanel.add(bookBtn);
        btnPanel.add(editApp);
        btnPanel.add(powerOn);
        btnPanel.add(gamesApp);
        btnPanel.add(shopApp);
        btnPanel.add(endDay);
        btnPanel.add(ticTacToeApp);
        btnPanel.add(rpsGame);
        btnPanel.add(singleBtn);
        btnPanel.add(doubleBtn);
        btnPanel.add(tic1);
        btnPanel.add(tic2);
        btnPanel.add(tic2);
        btnPanel.add(tic3);
        btnPanel.add(tic4);
        btnPanel.add(tic5);
        btnPanel.add(tic6);
        btnPanel.add(tic7);
        btnPanel.add(tic8);
        btnPanel.add(tic9);
        btnPanel.add(checkWinner);

        addActionListeners();
    }

    private void addActionListeners() {
        usernameText.addActionListener(e -> {
            player.setUsername(usernameText.getText());
            System.out.println("username: " + player.getUsername());
            //cardLayoutPanel.showCard("Background");
            cardLayoutPanel.showCard("TutorialScreen");
        });

        passwordText.addActionListener(e -> {
            String input = passwordText.getText();

            if (input.matches("\\d{4}")) {
                int passwordInt = Integer.parseInt(input);
                player.setPassword(passwordInt);
                System.out.println("password: " + player.getPassword());
                addPassword();
                cardLayoutPanel.showCard("AppScreen");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter exactly 4 digits.");
            }
        });

        passwordText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }

                if (passwordText.getText().length() >= 4) {
                    e.consume();
                }
            }
        });

        powerOn.addActionListener(e -> {
            //cardLayoutPanel.showCard("LoginInScreen");
            //cardLayoutPanel.showCard("AppScreen");

            JLabel usernameLabel = new JLabel(player.getUsername());
            usernameLabel.setFont(pressStartFont);
            usernameLabel.setForeground(Color.WHITE);
            usernameLabel.setBounds(300, 250, 300, 50);
            usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel loginInScreen = cardLayoutPanel.getLoginInScreen();
            loginInScreen.setLayout(null);
            loginInScreen.add(usernameLabel);
            loginInScreen.revalidate();
            loginInScreen.repaint();

            cardLayoutPanel.showCard("LoginInScreen");
        });

        livestreamApp.addActionListener(e -> {
            new Thread(() -> {
                while (!livestreamExited) {
                    String textToAppend;
                    int goodOrBad = (int) (Math.random() * 2);
                    if (goodOrBad == 1) {
                        textToAppend = livestream.getRandomGood() + "\n";
                    } else {
                        textToAppend = livestream.getRandomBad() + "\n";
                    }
                    String finalTextToAppend = textToAppend;
                    SwingUtilities.invokeLater(() -> {
                        livestreamChat.append(finalTextToAppend);
                        livestreamChat.setCaretPosition(livestreamChat.getDocument().getLength()); // scroll to bottom
                        cardLayoutPanel.getLivestreamScreen().revalidate();
                        cardLayoutPanel.getLivestreamScreen().repaint();
                    });
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException f) {
                        f.printStackTrace();
                    }
                }
            }).start();
            cardLayoutPanel.showCard("LivestreamScreen");
        });

        editApp.addActionListener(e -> {
            cardLayoutPanel.showCard("EditAppScreen");
        });

        mailApp.addActionListener(e -> {
            //animation
            ArrayList<BufferedImage> mailImages = new ArrayList<>();
            for (int i = 1; i < 15; i++) {
                try {
                    String file = "src/MailImages/" + i + ".png";
                    BufferedImage mailImg = ImageIO.read(new File(file));
                    mailImages.add(mailImg);
                }
                catch (IOException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            JPanelAnimation mailScreenAnimation = new JPanelAnimation(cardLayoutPanel, "MailScreen", mailImages, 50, 1);
            cardLayoutPanel.getMainPanel().add(mailScreenAnimation, "MailScreenAnimation");

            cardLayoutPanel.showCard("MailScreenAnimation");

        });

        nextButton.addActionListener(e -> {
            cardLayoutPanel.showCard("Background");
        });

        accept.addActionListener(e -> {
            int added = player.addAura();
            player.addAds(1);
            JLabel label = new JLabel("You gained " + added + " aura!");
            label.setFont(pressStartFont);
            label.setBounds(280, 150, 1000, 400);
            cardLayoutPanel.getAuraInfo().add(label);
            cardLayoutPanel.getAuraInfo().add(next);
            cardLayoutPanel.getAuraInfo().revalidate();
            cardLayoutPanel.getAuraInfo().repaint();
            cardLayoutPanel.showCard("auraInfo");
            //cardLayoutPanel.showCard("AppScreen");
        });

        decline.addActionListener(e -> {
            int deleted = player.deleteAura();
            JLabel label = new JLabel("You lost " + deleted + " aura!");
            label.setFont(pressStartFont);
            label.setBounds(280, 150, 1000, 400);
            cardLayoutPanel.getAuraInfo().add(label);
            cardLayoutPanel.getAuraInfo().add(next);
            cardLayoutPanel.getAuraInfo().revalidate();
            cardLayoutPanel.getAuraInfo().repaint();
            cardLayoutPanel.showCard("auraInfo");
            //cardLayoutPanel.showCard("AppScreen");
        });

        next.addActionListener(e -> {
            cardLayoutPanel.showCard("AppScreen");
        });

        gamesApp.addActionListener(e -> {
            cardLayoutPanel.showCard("GamesScreen");
        });

        rpsGame.addActionListener(e -> {
            cardLayoutPanel.showCard("RockPaperScissors");
        });

        ticTacToeApp.addActionListener(e -> {
            cardLayoutPanel.showCard("TicTacToe");
        });

        checkWinner.addActionListener(e -> {
            if (ticTacToe.getWinner().equals("You win")) {
                TTTWin.setBounds(570,170,175,52);
                cardLayoutPanel.getTicTacToe().add(TTTWin);
                TTTNull.setVisible(false);
                cardLayoutPanel.getTicTacToe().revalidate();
                cardLayoutPanel.getTicTacToe().repaint();
            } else if (ticTacToe.getWinner().equals("AI wins")) {
                TTTLose.setBounds(573,170,170,50);
                cardLayoutPanel.getTicTacToe().add(TTTLose);
                TTTNull.setVisible(false);
                cardLayoutPanel.getTicTacToe().revalidate();
                cardLayoutPanel.getTicTacToe().repaint();
            } else if (ticTacToe.getWinner().equals("Draw")) {
                TTTDraw.setBounds(570,170,170,50);
                cardLayoutPanel.getTicTacToe().add(TTTDraw);
                TTTNull.setVisible(false);
                cardLayoutPanel.getTicTacToe().revalidate();
                cardLayoutPanel.getTicTacToe().repaint();
            } else {
                TTTNull.setBounds(565,170,195,48);
                cardLayoutPanel.getTicTacToe().add(TTTNull);
                cardLayoutPanel.getTicTacToe().revalidate();
                cardLayoutPanel.getTicTacToe().repaint();
            }
        });

        singleBtn.addActionListener(e -> {
            pressedKeys = new boolean[128];
            singleBtn.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    int key = e.getKeyCode();
                    pressedKeys[key] = true;
                }
            });
            vsAnimation();
        });


        doubleBtn.addActionListener(e -> {
            vsAnimation();
        });

        shopApp.addActionListener( e -> {
            cardLayoutPanel.showCard("shopScreen");
        });

        shop.addActionListener(e -> {
            ArrayList<BufferedImage> shopImages = new ArrayList<>();
            for (int i = 2; i < 9; i++) {
                try {
                    String file = "src/shopimages/" + i + ".png";
                    BufferedImage shopImg = ImageIO.read(new File(file));
                    shopImages.add(shopImg);
                }
                catch (IOException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            JPanelAnimation shopAnimation = new JPanelAnimation(cardLayoutPanel, "shop", shopImages, 50, 1);
            cardLayoutPanel.getMainPanel().add(shopAnimation, "shopAnimation");

            cardLayoutPanel.showCard("shopAnimation");
        });
    }

//    public void setContinueButtonListener(ActionListener listener) {
//        bookBtn.addActionListener(listener);
//    }

    private void customizeButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

    private void setButtonOpaque(JButton button) {
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
    }

    public JPanel getBtnPanel() {
        return btnPanel;
    }

    public JButton getLivestreamApp() {
        return livestreamApp;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getBookBtn() {
        return bookBtn;
    }

    public JTextField getUsernameText() {
        return usernameText;
    }

    public JTextField getPasswordText() {
        return passwordText;
    }

    public JTextArea getLivestreamChat() {
        return livestreamChat;
    }

    public JButton getMailApp() {
        return mailApp;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JButton getEditApp() {
        return editApp;
    }

    public JButton getPowerOn() {
        return powerOn;
    }

    public JButton getGamesApp() {
        return gamesApp;
    }

    public JButton getShopApp() {
        return shopApp;
    }

    public JButton getEndDay() {
        return endDay;
    }

    public JButton getAccept() {
        return accept;
    }

    public JButton getDecline() {
        return decline;
    }

    public JButton getTicTacToeApp() {
        return ticTacToeApp;
    }

    public JButton getRpsGame() {
        return rpsGame;
    }

    public JButton getSingleBtn() {
        return singleBtn;
    }

    public JButton getDoubleBtn() {
        return doubleBtn;
    }

    public JButton getTic1() {
        return tic1;
    }

    public JButton getTic2() {
        return tic2;
    }

    public JButton getTic3() {
        return tic3;
    }

    public JButton getTic4() {
        return tic4;
    }

    public JButton getTic5() {
        return tic5;
    }

    public JButton getTic6() {
        return tic6;
    }

    public JButton getTic7() {
        return tic7;
    }

    public JButton getTic8() {
        return tic8;
    }

    public JButton getTic9() {
        return tic9;
    }

    public JButton getCheckWinner() {
        return checkWinner;
    }

    public Component getShop() {
        return shop;
    }

    public Component getNext() {
        return next;
    }



    public void addPassword() {
        JLabel passwordLabel = new JLabel(String.valueOf(player.getPassword()));
        passwordLabel.setFont(pressStartFont);
        Color color = Color.decode("#1a37ac");
        passwordLabel.setForeground(color);
        passwordLabel.setBounds(40, 325, 100, 50);

        JPanel appScreen = cardLayoutPanel.getAppScreen();
        appScreen.setLayout(null);
        appScreen.add(passwordLabel);
        appScreen.revalidate();
        appScreen.repaint();
    }

    public void vsAnimation() {
        ArrayList<BufferedImage> vsAnimation = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            String fileName = "src/images/RockPaperScissorsGame/vsAnimation/frame_" + i + ".jpg";
            try {
                vsAnimation.add(ImageIO.read(new File(fileName)));
            } catch (IOException e2) {
                System.out.println(e2.getMessage());
            }
        }

        JPanelAnimation animationPanel = new JPanelAnimation(this.cardLayoutPanel, "RoundScreen", vsAnimation, 100, 1);
        this.mainPanel.add(animationPanel, "animation");
        this.cardLayoutPanel.showCard("animation");

        JLabel roundLabel = new JLabel("Round 1");
        roundLabel.setFont(pressStartFont.deriveFont(45f));
        Color color = Color.decode("#5d31b8");
        roundLabel.setForeground(color);
        roundLabel.setBounds(335, 310, 500, 50);
        //usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel usernameLabel = new JLabel(usernameText.getText());
        usernameLabel.setFont(pressStartFont.deriveFont(45f));
        Color color2 = Color.decode("#a589e8");
        usernameLabel.setForeground(color2);
        usernameLabel.setBounds(610, 600, 200, 50);

        JPanel roundScreen = cardLayoutPanel.getRoundScreen();
        roundScreen.setLayout(null);
        roundScreen.add(roundLabel);
        roundScreen.add(usernameLabel);
        roundScreen.revalidate();
        roundScreen.repaint();

        SoundUtils.playSound("src/Round 1 Fight! (Mortal Kombat Meme) - Sound Effect for editing.wav");

        if (pressedKeys[65]) {
            //cardLayoutPanel.showCard();
            if (aiPlayer() == 1) {
                cardLayoutPanel.showCard("RockTie");
            } else if (aiPlayer() == 2) {
                cardLayoutPanel.showCard("RockWin");
            } else {
                cardLayoutPanel.showCard("RockLose");
            }
        } else if (pressedKeys[83]) {

        } else if (pressedKeys[68]) {

        } else {
            System.out.println("Invalid");
        }
    }

    private int aiPlayer() {
        int num = (int) (Math.random() * 3-1+1) + 1;
        return num;
    }


}
