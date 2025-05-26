import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClass {
    private JButton startbtn;
    private JPanel btnPanel;
    private Frame cardLayoutPanel;

    public ButtonClass(Frame cardLayoutPanel) {
        btnPanel = new JPanel(new BorderLayout());
        this.cardLayoutPanel = cardLayoutPanel;

        //create buttons
        startbtn = new JButton();

        //set opaque
        customizeButton(startbtn);

        //set button size
        startbtn.setBounds(1,1,1,1);

        btnPanel.add(startbtn);

        addActionListeners(cardLayoutPanel);
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
}
