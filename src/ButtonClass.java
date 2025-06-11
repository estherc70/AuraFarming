import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ButtonClass {
    private Player player;
    private JButton livestreamApp, nextButton, mailApp, bookBtn,
            editApp, powerOn, shopApp, gamesApp,
            endDay, accept, decline, next,
            ticTacToeApp, rpsGame, singleBtn, doubleBtn,
            shop, backBtnLS, backBtnRPS, backBtnTTT,
            backBtnEdit, returnBtn;
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
    private int round;
    private int wins;
    private int lose;


    public ButtonClass(Frame cardLayoutPanel,Player player, JPanel mainPanel)  {
        livestream = new Livestream(player);
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
        backBtnLS = new JButton();
        backBtnEdit = new JButton();
        backBtnRPS = new JButton();
        backBtnTTT = new JButton();
        returnBtn = new JButton();
        round = 1;
        wins = 1;
        lose = 0;

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

        setButtonOpaque(backBtnEdit);
        setButtonOpaque(backBtnLS);
        setButtonOpaque(backBtnRPS);
        setButtonOpaque(backBtnTTT);

        customizeButton(powerOn);

        customizeButton(returnBtn);

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
        backBtnEdit.setBounds(200,85,17,17);
        backBtnTTT.setBounds(200,85,17,17);
        backBtnRPS.setBounds(200,85,17,17);
        backBtnLS.setBounds(200,85,17,17);
        returnBtn.setBounds(450,450,100,50);

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
        btnPanel.add(backBtnEdit);
        btnPanel.add(backBtnLS);
        btnPanel.add(backBtnEdit);
        btnPanel.add(backBtnRPS);
        btnPanel.add(backBtnTTT);
        btnPanel.add(returnBtn);

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
//            livestream.setLoop(true);
            new Thread(() -> {
                while (!livestreamExited) {
//                    livestream.incrementByRandomNumber();
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
                        int randomIncrement = (int) (Math.random() * 1001);
                        player.addFollowers(randomIncrement);
                        System.out.println("Current followers: " + player.getFollowers());
                    });
                    try {
                        Thread.sleep(600);
                    } catch (InterruptedException f) {
                        f.printStackTrace();
                        break;
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
            if (!ticTacToe.getGameEnded()) {
                if (ticTacToe.getWinner().equals("You win")) {
                    ticTacToe.setGameEnded(true);
                    TTTWin.setBounds(570,170,175,52);
                    cardLayoutPanel.getTicTacToe().add(TTTWin);
                    TTTNull.setVisible(false);
                    cardLayoutPanel.getTicTacToe().revalidate();
                    cardLayoutPanel.getTicTacToe().repaint();
                    player.addAura();
                    System.out.println(player.getAura());
                } else if (ticTacToe.getWinner().equals("AI wins")) {
                    ticTacToe.setGameEnded(true);
                    TTTLose.setBounds(573,170,170,50);
                    cardLayoutPanel.getTicTacToe().add(TTTLose);
                    TTTNull.setVisible(false);
                    cardLayoutPanel.getTicTacToe().revalidate();
                    cardLayoutPanel.getTicTacToe().repaint();
                    player.deleteAura();
                    System.out.println(player.getAura());
                } else if (ticTacToe.getWinner().equals("Draw")) {
                    ticTacToe.setGameEnded(true);
                    TTTDraw.setBounds(570,170,170,50);
                    cardLayoutPanel.getTicTacToe().add(TTTDraw);
                    TTTNull.setVisible(false);
                    cardLayoutPanel.getTicTacToe().revalidate();
                    cardLayoutPanel.getTicTacToe().repaint();
                } else {
                    TTTNull.setBounds(565,170,195,48);
                    TTTNull.setVisible(true);
                    cardLayoutPanel.getTicTacToe().add(TTTNull);
                    cardLayoutPanel.getTicTacToe().revalidate();
                    cardLayoutPanel.getTicTacToe().repaint();
                }
            }
        });

        singleBtn.addActionListener(e -> {
            pressedKeys = new boolean[128];
            //hasPlayedIntroAnimation = true;
            vsAnimation();
        });

        doubleBtn.addActionListener(e -> {
            pressedKeys = new boolean[128];
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

        backBtnLS.addActionListener(e -> {
//            livestream.setLoop(false);
//            livestream = null;

            cardLayoutPanel.showCard("AppScreen");
        });

        backBtnEdit.addActionListener(e -> {
            cardLayoutPanel.showCard("AppScreen");
        });

        backBtnRPS.addActionListener(e -> {
            cardLayoutPanel.showCard("AppScreen");
        });

        backBtnTTT.addActionListener(e -> {
            ticTacToe.resetGame();
            cardLayoutPanel.getTicTacToe().remove(TTTWin);
            cardLayoutPanel.getTicTacToe().remove(TTTLose);
            cardLayoutPanel.getTicTacToe().remove(TTTDraw);
            cardLayoutPanel.getTicTacToe().remove(TTTNull);

            cardLayoutPanel.getTicTacToe().revalidate();
            cardLayoutPanel.getTicTacToe().repaint();
            cardLayoutPanel.showCard("AppScreen");
        });

        endDay.addActionListener(e -> {
            cardLayoutPanel.showCard("EndDayScreen");
        });
    }

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

    public JButton getBackBtnLS() {
        return backBtnLS;
    }

    public JButton getBackBtnRPS() {
        return backBtnRPS;
    }

    public JButton getBackBtnTTT() {
        return backBtnTTT;
    }

    public JButton getBackBtnEdit() {
        return backBtnEdit;
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

        SoundUtils.playSound("src/Round 1 Fight! (Mortal Kombat Meme) - Sound Effect for editing.wav");

        animationPanel.setOnComplete(() -> {
            this.mainPanel.remove(animationPanel);
            this.mainPanel.revalidate();
            this.mainPanel.repaint();

            JPanel roundScreen = cardLayoutPanel.getRoundScreen();
            roundScreen.setLayout(null);

            JLabel roundLabel = new JLabel("Round " + round);
            roundLabel.setFont(pressStartFont.deriveFont(45f));
            roundLabel.setForeground(Color.decode("#5d31b8"));
            roundLabel.setBounds(335, 310, 500, 50);

            JLabel winLabelPlayer1 = new JLabel("Wins: " + wins);
            winLabelPlayer1.setFont(pressStartFont.deriveFont(25f));
            winLabelPlayer1.setForeground(Color.decode("#5d31b8"));
            winLabelPlayer1.setBounds(430, 430, 200, 60);

            JLabel winLabelPlayer2 = new JLabel("Wins: " + lose);
            winLabelPlayer2.setFont(pressStartFont.deriveFont(25f));
            winLabelPlayer2.setForeground(Color.decode("#5d31b8"));
            winLabelPlayer2.setBounds(15, 25, 200, 60);

            JLabel usernameLabel = new JLabel(usernameText.getText());
            usernameLabel.setFont(pressStartFont.deriveFont(45f));
            usernameLabel.setForeground(Color.decode("#a589e8"));
            usernameLabel.setBounds(610, 600, 200, 50);

            roundScreen.removeAll();
            roundScreen.add(roundLabel);
            roundScreen.add(usernameLabel);
            roundScreen.add(winLabelPlayer1);
            roundScreen.add(winLabelPlayer2);
            roundScreen.revalidate();
            roundScreen.repaint();

            roundScreen.requestFocusInWindow();

            setupRoundScreenKeyListener(roundScreen);
        });
    }

    private void switchToResult(String move) {
        int ai = aiPlayer();
        String result;

        if (ai == 1) {
            result = move + "Tie";
        } else if (ai == 2) {
            wins++;
            result = move + "Win";
        } else {
            lose++;
            result = move + "Lose";
        }

        if (wins == 2) {
            ArrayList<BufferedImage> vsAnimation2 = new ArrayList<>();
            for (int i = 0; i < 24; i++) {
                String fileName = "src/images/RockPaperScissorsGame/winAnimation/frame" + i + ".jpg";
                try {
                    vsAnimation2.add(ImageIO.read(new File(fileName)));
                } catch (IOException e2) {
                    System.out.println(e2.getMessage());
                }
            }

            JPanelAnimation animationPanel2 = new JPanelAnimation(this.cardLayoutPanel, "EndScreen", vsAnimation2, 100, 2);

            this.mainPanel.add(animationPanel2, "animation2");
            this.cardLayoutPanel.showCard("animation2");

            animationPanel2.setOnComplete(() -> {
                this.mainPanel.remove(animationPanel2);
                this.mainPanel.revalidate();
                this.mainPanel.repaint();

                cardLayoutPanel.showCard("RPSWinPage");
                JPanel rpsWinPage = cardLayoutPanel.getRpsWinPage();
                rpsWinPage.setLayout(null);
                JButton returnBtn = new JButton("Return");
                returnBtn.setBounds(650, 407, 125, 45);
                returnBtn.setFont(pressStartFont.deriveFont(20f));
                setButtonOpaque(returnBtn);

                int num = player.addAura();

                JLabel auraGained = new JLabel(String.valueOf(num));
                auraGained.setFont(pressStartFont.deriveFont(18f));
                auraGained.setForeground(Color.decode("#ffcc00"));
                auraGained.setBounds(510, 245, 100, 50);

                int num2 = player.getFollowers();

                JLabel totalFollowers = new JLabel(String.valueOf(num2));
                totalFollowers.setFont(pressStartFont.deriveFont(18f));
                totalFollowers.setForeground(Color.decode("#ffcc00"));
                totalFollowers.setBounds(560, 275, 100, 50);

                int num3 = player.getAura();

                JLabel totalAura = new JLabel(String.valueOf(num3));
                totalAura.setFont(pressStartFont.deriveFont(18f));
                totalAura.setForeground(Color.decode("#ffcc00"));
                totalAura.setBounds(500, 297, 100, 50);

                round = 1;
                wins = 0;
                lose = 0;

                returnBtn.addActionListener(e -> {
                    cardLayoutPanel.showCard("AppScreen");
                });

                rpsWinPage.add(returnBtn);
                rpsWinPage.add(auraGained);
                rpsWinPage.add(totalFollowers);
                rpsWinPage.add(totalAura);
                rpsWinPage.revalidate();
                rpsWinPage.repaint();
            });
            return;
        }
        cardLayoutPanel.showCard(result);

        new javax.swing.Timer(3000, e -> {
            round++;
            updateRoundScreen();
            cardLayoutPanel.showCard("RoundScreen");
            ((javax.swing.Timer) e.getSource()).stop();
        }).start();
    }

    private void updateRoundScreen() {
        JPanel roundScreen = cardLayoutPanel.getRoundScreen();
        roundScreen.setLayout(null);
        roundScreen.removeAll();

        JLabel roundLabel = new JLabel("Round " + round);
        roundLabel.setFont(pressStartFont.deriveFont(45f));
        roundLabel.setForeground(Color.decode("#5d31b8"));
        roundLabel.setBounds(335, 310, 500, 50);

        JLabel winLabelPlayer1 = new JLabel("Wins: " + wins);
        winLabelPlayer1.setFont(pressStartFont.deriveFont(25f));
        winLabelPlayer1.setForeground(Color.decode("#5d31b8"));
        winLabelPlayer1.setBounds(430, 430, 200, 60);

        JLabel winLabelPlayer2 = new JLabel("Wins: " + lose);
        winLabelPlayer2.setFont(pressStartFont.deriveFont(25f));
        winLabelPlayer2.setForeground(Color.decode("#5d31b8"));
        winLabelPlayer2.setBounds(15, 25, 200, 60);

        JLabel usernameLabel = new JLabel(usernameText.getText());
        usernameLabel.setFont(pressStartFont.deriveFont(45f));
        usernameLabel.setForeground(Color.decode("#a589e8"));
        usernameLabel.setBounds(610, 600, 200, 50);

        roundScreen.add(roundLabel);
        roundScreen.add(usernameLabel);
        roundScreen.add(winLabelPlayer1);
        roundScreen.add(winLabelPlayer2);

        roundScreen.revalidate();
        roundScreen.repaint();

        setupRoundScreenKeyListener(roundScreen);

        SwingUtilities.invokeLater(roundScreen::requestFocusInWindow);
    }

    void setupRoundScreenKeyListener(JPanel roundScreen) {
        roundScreen.setFocusable(true);
        roundScreen.requestFocusInWindow();

        for (KeyListener kl : roundScreen.getKeyListeners()) {
            roundScreen.removeKeyListener(kl);
        }

        roundScreen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyChar());
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_A) {
                    switchToResult("Rock");
                } else if (key == KeyEvent.VK_S) {
                    switchToResult("Paper");
                } else if (key == KeyEvent.VK_D) {
                    switchToResult("Scissors");
                } else {
                    System.out.println("Invalid key");
                }
            }
        });
    }

    private int aiPlayer() {
        return (int) (Math.random() * 3) + 1;
    }

    public JButton getReturnBtn() {
        return returnBtn;
    }
}
