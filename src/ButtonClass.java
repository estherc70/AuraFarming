import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ButtonClass {
    private Player player;
    private JButton livestreamApp, nextButton, mailApp, homePage;
    private JTextArea livestreamChat;
    private JTextField usernameText;
    private JPanel btnPanel;
    private Frame cardLayoutPanel;
    private JPanelAnimation animation;
    private Livestream livestream;


    public ButtonClass(Frame cardLayoutPanel) {
        livestream = new Livestream();
        btnPanel = new JPanel(new BorderLayout());
        this.cardLayoutPanel = cardLayoutPanel;
        player = new Player();

        //create buttons
        usernameText = new JTextField(15);
        livestreamChat = new JTextArea();
        livestreamApp = new JButton();
        nextButton = new JButton();
        mailApp = new JButton();
        //testing
        homePage = new JButton();

        //set opaque
//        customizeButton(livestreamApp);
        livestreamApp.setOpaque(true);
        livestreamApp.setContentAreaFilled(true);
        livestreamApp.setBorderPainted(true);

        nextButton.setOpaque(true);
        nextButton.setContentAreaFilled(true);
        nextButton.setBorderPainted(true);

        mailApp.setOpaque(true);
        mailApp.setContentAreaFilled(true);
        mailApp.setBorderPainted(true);

        //testing
        homePage.setOpaque(true);
        homePage.setContentAreaFilled(true);
        homePage.setBorderPainted(true);

        livestreamChat.setEditable(true);
        livestreamChat.setLineWrap(true);

        //set text field fonts
        usernameText.setFont(new Font("Serif", Font.BOLD, 60));
        livestreamApp.setFont(new Font("Serif", Font.ITALIC, 15));

        //set button/text field size
        usernameText.setBounds(150,360,700,75);
        livestreamApp.setBounds(515,165,90,90);
        nextButton.setBounds(515,165,90,90);
        livestreamChat.setBounds(630,80,280,500);
        mailApp.setBounds(400, 165, 90, 90);
        homePage.setBounds(500, 180, 90, 90);

        //livestreamApp.setVisible(false);

        btnPanel.add(usernameText);
        btnPanel.add(livestreamApp);
        btnPanel.add(nextButton);
        btnPanel.add(livestreamChat);
        btnPanel.add(mailApp);
        btnPanel.add(homePage);

        addActionListeners();
    }

    private void addActionListeners() {
        usernameText.addActionListener(e -> {
            player.setUsername(usernameText.getText());
            System.out.println("username: " + player.getUsername());
            //cardLayoutPanel.showCard("Background");
            cardLayoutPanel.showCard("TutorialScreen");
        });

        livestreamApp.addActionListener(e -> {
            cardLayoutPanel.showCard("LivestreamScreen");
        });

        mailApp.addActionListener(e -> {
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

        homePage.addActionListener(e ->  {
            cardLayoutPanel.showCard("Background");
        });

        nextButton.addActionListener(e -> {
            cardLayoutPanel.showCard("Background");
        });
    }

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

    public JTextField getUsernameText() {
        return usernameText;
    }

    public JTextArea getLivestreamChat() {
        return livestreamChat;
    }

    public JButton getMailApp() {
        return mailApp;
    }

    public JButton getHomePage() {
        return homePage;
    }


}
