import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClass {
    private Player player;
    private JButton livestreamApp;
    private JTextArea livestreamChat;
    private JTextField usernameText;
    private JPanel btnPanel;
    private Frame cardLayoutPanel;

    public ButtonClass(Frame cardLayoutPanel) {
        btnPanel = new JPanel(new BorderLayout());
        this.cardLayoutPanel = cardLayoutPanel;
        player = new Player();

        //create buttons
        usernameText = new JTextField(15);
        livestreamChat = new JTextArea();
        livestreamApp = new JButton();

        //set opaque
//        customizeButton(livestreamApp);
        livestreamApp.setOpaque(true);
        livestreamApp.setContentAreaFilled(true);
        livestreamApp.setBorderPainted(true);

        livestreamChat.setEditable(true);
        livestreamChat.setLineWrap(true);

        //set text field fonts
        usernameText.setFont(new Font("Serif", Font.BOLD, 60));
        livestreamApp.setFont(new Font("Serif", Font.ITALIC, 15));

        //set button/text field size
        usernameText.setBounds(150,360,700,75);
        livestreamApp.setBounds(300,150,100,100);
        livestreamChat.setBounds(630,80,280,500);

        btnPanel.add(usernameText);
        btnPanel.add(livestreamApp);
        btnPanel.add(livestreamChat);

        addActionListeners();
    }

    private void addActionListeners() {
        usernameText.addActionListener(e -> {
            player.setUsername(usernameText.getText());
            System.out.println(player.getUsername());
            cardLayoutPanel.showCard("Background");
        });

        livestreamApp.addActionListener(e -> {
            cardLayoutPanel.showCard("LivestreamScreen");
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

    public JTextField getUsernameText() {
        return usernameText;
    }

    public JTextArea getLivestreamChat() {
        return livestreamChat;
    }
}
