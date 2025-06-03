import javax.swing.*;
import java.util.ArrayList;

public class TicTacToe extends JFrame {
    private JButton[] buttons;
    private boolean[] position;
    private String[] layout;
    private ImageIcon xIcon, yIcon;
    private boolean gameEnd;
    private String winner;

    public TicTacToe() {
        buttons = new JButton[9];
        position = new boolean[9];
        layout = new String[9];
        gameEnd = false;
        winner = "";

        JPanel mainPanel = PanelClass.createPanel("src/images/tictactoebg.PNG");
        mainPanel.setLayout(null);
        setContentPane(mainPanel);

        xIcon = new ImageIcon("src/images/tictactoeX.PNG");
        yIcon = new ImageIcon("src/images/tictactoeY.PNG");

        buttons[0] = new JButton();
        buttons[1] = new JButton();
        buttons[2] = new JButton();
        buttons[3] = new JButton();
        buttons[4] = new JButton();
        buttons[5] = new JButton();
        buttons[6] = new JButton();
        buttons[7] = new JButton();
        buttons[8] = new JButton();

        buttons[0].setOpaque(true);
        buttons[0].setContentAreaFilled(true);
        buttons[0].setBorderPainted(true);

        buttons[1].setOpaque(true);
        buttons[1].setContentAreaFilled(true);
        buttons[1].setBorderPainted(true);

        buttons[2].setOpaque(true);
        buttons[2].setContentAreaFilled(true);
        buttons[2].setBorderPainted(true);

        buttons[3].setOpaque(true);
        buttons[3].setContentAreaFilled(true);
        buttons[3].setBorderPainted(true);

        buttons[4].setOpaque(true);
        buttons[4].setContentAreaFilled(true);
        buttons[4].setBorderPainted(true);

        buttons[5].setOpaque(true);
        buttons[5].setContentAreaFilled(true);
        buttons[5].setBorderPainted(true);

        buttons[6].setOpaque(true);
        buttons[6].setContentAreaFilled(true);
        buttons[6].setBorderPainted(true);

        buttons[7].setOpaque(true);
        buttons[7].setContentAreaFilled(true);
        buttons[7].setBorderPainted(true);

        buttons[8].setOpaque(true);
        buttons[8].setContentAreaFilled(true);
        buttons[8].setBorderPainted(true);

        buttons[0].setBounds(0,0,166,166);
        buttons[1].setBounds(166,0,166,166);
        buttons[2].setBounds(332,0,166,166);
        buttons[3].setBounds(0,166,166,166);
        buttons[4].setBounds(166,166,166,166);
        buttons[5].setBounds(332,166,166,166);
        buttons[6].setBounds(0,332,166,166);
        buttons[7].setBounds(166,332,166,166);
        buttons[8].setBounds(332,332,166,166);

        mainPanel.add(buttons[0]);
        mainPanel.add(buttons[1]);
        mainPanel.add(buttons[2]);
        mainPanel.add(buttons[3]);
        mainPanel.add(buttons[4]);
        mainPanel.add(buttons[5]);
        mainPanel.add(buttons[6]);
        mainPanel.add(buttons[7]);
        mainPanel.add(buttons[8]);

        addActionListeners();

        setTitle("TicTacToe");
        setSize(500, 525); // Set the size of the window
        setResizable(false); // Disable resizing the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);

    }

    private void addActionListeners() {
        buttons[0].addActionListener(e -> {
            getButtonReady(0);
        });
        buttons[1].addActionListener(e -> {
            getButtonReady(1);
        });
        buttons[2].addActionListener(e -> {
            getButtonReady(2);
        });
        buttons[3].addActionListener(e -> {
            getButtonReady(3);
        });
        buttons[4].addActionListener(e -> {
            getButtonReady(4);
        });
        buttons[5].addActionListener(e -> {
            getButtonReady(5);
        });
        buttons[6].addActionListener(e -> {
            getButtonReady(6);
        });
        buttons[7].addActionListener(e -> {
            getButtonReady(7);
        });
        buttons[8].addActionListener(e -> {
            getButtonReady(8);
        });
    }

    public void setRandomPosition() {
        int positionLocation = getRandomPosition();
        buttons[positionLocation].setIcon(yIcon);
        position[positionLocation] = true;
        layout[positionLocation] = "O";
    }

    public int getRandomPosition() {
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
            if (!position[i]) {
                a.add(i);
            }
        }
        int randomPos = (int) (Math.random() * a.size());
        return a.get(randomPos);
    }

    public boolean checkAllFilled() {
        int length = position.length;
        int counterFilled = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i]) {
                counterFilled++;
            }
        }
        if (counterFilled == length) {
            return true;
        } else {
            return false;
        }
    }

    public void checkWinner() {
        if ((layout[0] != null && layout[3] != null && layout[6] != null) &&
                (layout[0].equals("X") && layout[3].equals("X") && layout[6].equals("X"))) { //X vertical
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[1] != null && layout[4] != null && layout[7] != null) &&
                (layout[1].equals("X") && layout[4].equals("X") && layout[7].equals("X"))) {
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[2] != null && layout[5] != null && layout[8] != null) &&
                (layout[2].equals("X") && layout[5].equals("X") && layout[8].equals("X"))) {
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[0] != null && layout[1] != null && layout[2] != null) &&
                (layout[0].equals("X") && layout[1].equals("X") && layout[2].equals("X"))) { //X horizontal
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[3] != null && layout[4] != null && layout[5] != null) &&
                (layout[3].equals("X") && layout[4].equals("X") && layout[5].equals("X"))) {
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[6] != null && layout[7] != null && layout[8] != null) &&
                (layout[6].equals("X") && layout[7].equals("X") && layout[8].equals("X"))) {
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[0] != null && layout[4] != null && layout[8] != null) &&
                (layout[0].equals("X") && layout[4].equals("X") && layout[8].equals("X"))) { //X diagonal
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[2] != null && layout[4] != null && layout[6] != null) &&
                (layout[2].equals("X") && layout[4].equals("X") && layout[6].equals("X"))) {
            winner = "You win!";
            gameEnd = true;
            // -----------------------------------------------------------------------------------
        } else if ((layout[0] != null && layout[3] != null && layout[6] != null) &&
                (layout[0].equals("O") && layout[3].equals("O") && layout[6].equals("O"))) { //O vertical
            winner = "The AI wins!";
            gameEnd = true;
        } else if ((layout[1] != null && layout[4] != null && layout[7] != null) &&
                (layout[1].equals("O") && layout[4].equals("O") && layout[7].equals("O"))) {
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[2] != null && layout[5] != null && layout[8] != null) &&
                (layout[2].equals("O") && layout[5].equals("O") && layout[8].equals("O"))) {
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[0] != null && layout[1] != null && layout[2] != null) &&
                (layout[0].equals("O") && layout[1].equals("O") && layout[2].equals("O"))) { //O horizontal
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[3] != null && layout[4] != null && layout[5] != null) &&
                (layout[3].equals("O") && layout[4].equals("O") && layout[5].equals("O"))) {
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[6] != null && layout[7] != null && layout[8] != null) &&
                (layout[6].equals("O") && layout[7].equals("O") && layout[8].equals("O"))) {
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[0] != null && layout[4] != null && layout[8] != null) &&
                (layout[0].equals("O") && layout[4].equals("O") && layout[8].equals("O"))) { //O diagonal
            winner = "You win!";
            gameEnd = true;
        } else if ((layout[2] != null && layout[4] != null && layout[6] != null) &&
                (layout[2].equals("O") && layout[4].equals("O") && layout[6].equals("O"))) {
            winner = "You win!";
            gameEnd = true;
        } else if (checkAllFilled()) {
            winner = "Draw!";
            gameEnd = true;
        }
        System.out.println(winner);
    }

    public void getButtonReady(int buttonNum) {
        if (!position[buttonNum]) {
            buttons[buttonNum].setIcon(xIcon);
            position[buttonNum] = true;
            layout[buttonNum] = "X";
            if (!checkAllFilled()) {
                setRandomPosition();
            }
        }
        checkWinner();
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

}
