import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyGuiPanel extends JPanel {
    // some row and column values for our JTextArea
    private static final int TXT_AREA_ROWS = 25;
    private static final int TXT_AREA_COLS = 80;

    // create the JTextArea, passing in the rows and columns values
    private JTextArea textArea = new JTextArea(TXT_AREA_ROWS, TXT_AREA_COLS);

    public MyGuiPanel() {
        // create the JScrollPane, adding our JTextArea
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        // lets add some buttons to the bottom of the GUI just for fun
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 5, 0));
        buttonPanel.add(new JButton("Save"));
        buttonPanel.add(new JButton("Open"));
        buttonPanel.add(new JButton("Delete"));
        buttonPanel.add(new JButton("Exit"));

        // let's add a title to the top:
        JLabel title = new JLabel("This is my Applications's Title", SwingConstants.CENTER);
        title.setFont(title.getFont().deriveFont(Font.BOLD, 24)); // and make
        // the text
        // *BIG*

        // use a BorderLayout for our GUI
        setLayout(new BorderLayout(5, 5));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(scroll, BorderLayout.CENTER); // add the scrollpane to the center
        add(buttonPanel, BorderLayout.PAGE_END); // the button panel to the
        // bottom
        add(title, BorderLayout.PAGE_START); // and the title JLabel to the top
    }

    private static void createAndShowGui() {
        // create our GUI JPanel
        MyGuiPanel mainPanel = new MyGuiPanel();

        // create a JFrame to add it to
        JFrame frame = new JFrame("My GUI");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel); // add the GUI to the JFrame
        frame.pack(); // tell the layout managers to do their work
        frame.setLocationByPlatform(true);
        frame.setVisible(true); // display the GUI
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}