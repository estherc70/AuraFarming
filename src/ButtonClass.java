import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClass {
    private Player player;
    private JButton startbtn;
    private JTextField usernameText;
    private JPanel btnPanel;
    private Frame cardLayoutPanel;

    public ButtonClass(Frame cardLayoutPanel) {
        btnPanel = new JPanel(new BorderLayout());
        this.cardLayoutPanel = cardLayoutPanel;
        player = new Player();

        //create buttons
        startbtn = new JButton();
        usernameText = new JTextField(15);

        //set opaque
        customizeButton(startbtn);

        //set text field fonts
        usernameText.setFont(new Font("Serif", Font.BOLD, 60));

        //set button/text field size
        startbtn.setBounds(1,1,1,1);
        usernameText.setBounds(150,430,750,100);

        btnPanel.add(startbtn);
        btnPanel.add(usernameText);

        addActionListeners(cardLayoutPanel);
        addActionListeners();
    }

    private void addActionListeners() {
        usernameText.addActionListener(e -> {
            player.setUsername(usernameText.getText());
            System.out.println(player.getUsername());
        });
    }

    private void addActionListeners(final Frame cardLayoutPanel) {
        startbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayoutPanel.showCard(""); // <--- switch to next screen
            }
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

    public JButton getStartbtn() {
        return startbtn;
    }

    public JTextField getUsernameText() {
        return usernameText;
    }
}
