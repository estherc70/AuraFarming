import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClass {
    private Player player;
    private JButton livestreamApp, nextButton;
    private JTextArea livestreamChat;
    private JTextField usernameText;
    private JPanel btnPanel;
    private Frame cardLayoutPanel;
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

        //set opaque
//        customizeButton(livestreamApp);
        livestreamApp.setOpaque(true);
        livestreamApp.setContentAreaFilled(true);
        livestreamApp.setBorderPainted(true);

        nextButton.setOpaque(true);
        nextButton.setContentAreaFilled(true);
        nextButton.setBorderPainted(true);

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

        //livestreamApp.setVisible(false);

        btnPanel.add(usernameText);
        btnPanel.add(livestreamApp);
        btnPanel.add(nextButton);
        btnPanel.add(livestreamChat);

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
//            while (livestream.checkInBounds()) {
//                if (livestream.getCurrentChat()[livestream.getChatNum()] != null) {
//                    livestreamChat.append(livestream.getCurrentChat()[livestream.getChatNum()]);
//                } else {
//                    String goodChat = livestream.getRandomGood();
//                    livestream.setCurrentChat(livestream.getChatNum(), goodChat);
//                    livestream.incrementChatNum();
//                    if (livestream.getChatNum() + 1 > livestream.getCurrentChat().length) {
//                        livestreamChat.remove(0);
//                    }
//                }

//
//
//                String goodChat = livestream.getRandomGood();
//                livestreamChat.append(goodChat);
//                livestream.setCurrentChat(livestream.getChatNum(), goodChat);
//                livestream.setChatNum(livestream.getChatNum() + 1);
//
//                String badChat = livestream.getRandomBad();
//                livestreamChat.append(badChat);
//                livestream.setCurrentChat(livestream.getChatNum(), badChat);
//                livestream.setChatNum(livestream.getChatNum() + 1);
//
//                if (livestream.getChatNum() + 1 < livestream.getCurrentChat().length) {
//                    livestream.setChatNum();
//                }
//            }

                String goodChat = livestream.getRandomGood();
                livestreamChat.append(goodChat);

                livestreamChat.append("\n");

                String badChat = livestream.getRandomBad();
                livestreamChat.append(badChat);

                livestreamChat.remove(0);
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
}
