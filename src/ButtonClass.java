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
            editApp, powerOn, shopApp, gamesApp, endDay, accept, decline, next, ticTacToe;
    private JTextArea livestreamChat;
    private JScrollPane scrollPane;
    private JTextField usernameText, passwordText;
    private JPanel btnPanel;
    private Frame cardLayoutPanel;
    private JPanelAnimation animation;
    private Livestream livestream;
    private Sponsors sponsors;
    private boolean livestreamExited;
    private Font pressStartFont;


    public ButtonClass(Frame cardLayoutPanel,Player player)  {
        livestream = new Livestream();
        btnPanel = new JPanel(new BorderLayout());
        this.cardLayoutPanel = cardLayoutPanel;
        this.player = player;
        sponsors = new Sponsors();
        livestreamExited = false;

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
        ticTacToe = new JButton();

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
            BufferedImage nextImage = ImageIO.read(new File("src/images/next.png"));
            nextIcon = new ImageIcon(nextImage);
            acceptIcon = new ImageIcon(acceptImage);
            declineIcon = new ImageIcon(declineImage);
            assert false;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        accept.setIcon(acceptIcon);
        decline.setIcon(declineIcon);
        next.setIcon(nextIcon);
        next.setBounds(350, 400, 400, 100);

        //set opaque
        //customizeButton(livestreamApp);

        nextButton.setOpaque(true);
        nextButton.setContentAreaFilled(true);
        nextButton.setBorderPainted(true);

        //customizeButton(mailApp);

        editApp.setOpaque(true);
        editApp.setContentAreaFilled(true);
        editApp.setBorderPainted(true);

        gamesApp.setOpaque(true);
        gamesApp.setContentAreaFilled(true);
        gamesApp.setBorderPainted(true);

        shopApp.setOpaque(true);
        shopApp.setContentAreaFilled(true);
        shopApp.setBorderPainted(true);

        endDay.setOpaque(true);
        endDay.setContentAreaFilled(true);
        endDay.setBorderPainted(true);

        bookBtn.setOpaque(false);
        bookBtn.setContentAreaFilled(false);
        bookBtn.setBorderPainted(false);

        accept.setOpaque(true);
        accept.setContentAreaFilled(true);
        accept.setBorderPainted(true);

        decline.setOpaque(true);
        decline.setContentAreaFilled(true);
        decline.setBorderPainted(true);

        next.setOpaque(true);
        next.setContentAreaFilled(true);
        next.setBorderPainted(true);

        ticTacToe.setOpaque(true);
        ticTacToe.setContentAreaFilled(true);
        ticTacToe.setBorderPainted(true);

        //testing
        customizeButton(powerOn);
//        powerOn.setOpaque(true);
//        powerOn.setContentAreaFilled(true);
//        powerOn.setBorderPainted(true);

        livestreamChat.setEditable(true);
        livestreamChat.setLineWrap(true);


        //set text field fonts
        //usernameText.setFont(new Font("Serif", Font.BOLD, 60));
        usernameText.setFont(pressStartFont);
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
        ticTacToe.setBounds(350,350,65,65);

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
        btnPanel.add(ticTacToe);

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
    }

//    public void setContinueButtonListener(ActionListener listener) {
//        bookBtn.addActionListener(listener);
//    }

    private void customizeButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
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

    public JButton getTicTacToe() {
        return ticTacToe;
    }

    public void addPassword() {
        JLabel passwordLabel = new JLabel(String.valueOf(player.getPassword()));
        passwordLabel.setFont(pressStartFont);
        Color color = Color.decode("#1a37ac");
        passwordLabel.setForeground(color);
        passwordLabel.setBounds(50, 325, 100, 50);

        JPanel appScreen = cardLayoutPanel.getAppScreen();
        appScreen.setLayout(null);
        appScreen.add(passwordLabel);
        appScreen.revalidate();
        appScreen.repaint();
    }
}
