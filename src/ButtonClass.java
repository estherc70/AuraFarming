import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ButtonClass {
    private Player player;
    private JButton livestreamApp, nextButton, mailApp, bookBtn,
            editApp, powerOn, shopApp, gamesApp, endDay;
    private JTextArea livestreamChat;
    private JScrollPane scrollPane;
    private JTextField usernameText;
    private JPanel btnPanel;
    private Frame cardLayoutPanel;
    private JPanelAnimation animation;
    private Livestream livestream;
    private Sponsors sponsors;
    private boolean livestreamExited;


    public ButtonClass(Frame cardLayoutPanel)  {
        livestream = new Livestream();
        btnPanel = new JPanel(new BorderLayout());
        this.cardLayoutPanel = cardLayoutPanel;
        player = new Player();
        sponsors = new Sponsors();
        livestreamExited = false;

        //create buttons
        usernameText = new JTextField(15);
        livestreamChat = new JTextArea(280,500);
        scrollPane = new JScrollPane(livestreamChat);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(630, 80, 280, 500);

        livestreamApp = new JButton();
        nextButton = new JButton();
        mailApp = new JButton();
        bookBtn = new JButton();
        bookBtn.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("SPACE"), "none");
        nextButton.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("SPACE"), "none");
        //testing
        editApp = new JButton();
        powerOn = new JButton();
        shopApp = new JButton();
        gamesApp = new JButton();
        endDay = new JButton();

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

        bookBtn.setOpaque(true);
        bookBtn.setContentAreaFilled(true);
        bookBtn.setBorderPainted(true);

        //testing
        customizeButton(powerOn);
//        powerOn.setOpaque(true);
//        powerOn.setContentAreaFilled(true);
//        powerOn.setBorderPainted(true);

        livestreamChat.setEditable(true);
        livestreamChat.setLineWrap(true);


        //set text field fonts
        usernameText.setFont(new Font("Serif", Font.BOLD, 60));
        livestreamApp.setFont(new Font("Serif", Font.ITALIC, 15));

        //set button/text field size
        usernameText.setBounds(150,360,700,75);
        mailApp.setBounds(323, 220, 65, 65);
        livestreamApp.setBounds(460,220,65,65);
        gamesApp.setBounds(600,220,65,65);
        editApp.setBounds(323, 345, 65, 65);
        shopApp.setBounds(460,345,65,65);
        endDay.setBounds(600,345,65,65);
        nextButton.setBounds(515,165,90,90);
        bookBtn.setBounds(625, 285, 145, 125);
        powerOn.setBounds(680,455,80,18);

        //livestreamApp.setVisible(false);

        btnPanel.add(usernameText);
        btnPanel.add(livestreamApp);
        btnPanel.add(nextButton);
        btnPanel.add(mailApp);
        btnPanel.add(bookBtn);
        btnPanel.add(editApp);
        btnPanel.add(powerOn);
        btnPanel.add(gamesApp);
        btnPanel.add(shopApp);
        btnPanel.add(endDay);

        addActionListeners();
    }

    private void addActionListeners() {
        usernameText.addActionListener(e -> {
            player.setUsername(usernameText.getText());
            System.out.println("username: " + player.getUsername());
            //cardLayoutPanel.showCard("Background");
            cardLayoutPanel.showCard("TutorialScreen");
        });

        powerOn.addActionListener(e -> {
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
}
