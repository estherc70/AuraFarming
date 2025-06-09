import javax.swing.*;
import java.util.ArrayList;

public class TicTacToe extends JFrame {
    private JButton[] buttons;
    private boolean[] position;
    private String[] layout;
    private ImageIcon xIcon, yIcon;
    private String winner;
    private boolean gameEnded;

    public TicTacToe() {
        gameEnded = false;
        buttons = new JButton[9];
        position = new boolean[9];
        layout = new String[9];
        winner = "";

        xIcon = new ImageIcon("src/images/tictactoeX.PNG");
        yIcon = new ImageIcon("src/images/tictactoeO.PNG");

        buttons[0] = new JButton();
        buttons[1] = new JButton();
        buttons[2] = new JButton();
        buttons[3] = new JButton();
        buttons[4] = new JButton();
        buttons[5] = new JButton();
        buttons[6] = new JButton();
        buttons[7] = new JButton();
        buttons[8] = new JButton();

        addActionListeners();
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
            winner = "You win";
        } else if ((layout[1] != null && layout[4] != null && layout[7] != null) &&
                (layout[1].equals("X") && layout[4].equals("X") && layout[7].equals("X"))) {
            winner = "You win";
        } else if ((layout[2] != null && layout[5] != null && layout[8] != null) &&
                (layout[2].equals("X") && layout[5].equals("X") && layout[8].equals("X"))) {
            winner = "You win";
        } else if ((layout[0] != null && layout[1] != null && layout[2] != null) &&
                (layout[0].equals("X") && layout[1].equals("X") && layout[2].equals("X"))) { //X horizontal
            winner = "You win";
        } else if ((layout[3] != null && layout[4] != null && layout[5] != null) &&
                (layout[3].equals("X") && layout[4].equals("X") && layout[5].equals("X"))) {
            winner = "You win";
        } else if ((layout[6] != null && layout[7] != null && layout[8] != null) &&
                (layout[6].equals("X") && layout[7].equals("X") && layout[8].equals("X"))) {
            winner = "You win";
        } else if ((layout[0] != null && layout[4] != null && layout[8] != null) &&
                (layout[0].equals("X") && layout[4].equals("X") && layout[8].equals("X"))) { //X diagonal
            winner = "You win";
        } else if ((layout[2] != null && layout[4] != null && layout[6] != null) &&
                (layout[2].equals("X") && layout[4].equals("X") && layout[6].equals("X"))) {
            winner = "You win";
            // -----------------------------------------------------------------------------------
        } else if ((layout[0] != null && layout[3] != null && layout[6] != null) &&
                (layout[0].equals("O") && layout[3].equals("O") && layout[6].equals("O"))) { //O vertical
            winner = "AI wins";
        } else if ((layout[1] != null && layout[4] != null && layout[7] != null) &&
                (layout[1].equals("O") && layout[4].equals("O") && layout[7].equals("O"))) {
            winner = "AI wins";
        } else if ((layout[2] != null && layout[5] != null && layout[8] != null) &&
                (layout[2].equals("O") && layout[5].equals("O") && layout[8].equals("O"))) {
            winner = "AI wins";
        } else if ((layout[0] != null && layout[1] != null && layout[2] != null) &&
                (layout[0].equals("O") && layout[1].equals("O") && layout[2].equals("O"))) { //O horizontal
            winner = "AI wins";
        } else if ((layout[3] != null && layout[4] != null && layout[5] != null) &&
                (layout[3].equals("O") && layout[4].equals("O") && layout[5].equals("O"))) {
            winner = "AI wins";
        } else if ((layout[6] != null && layout[7] != null && layout[8] != null) &&
                (layout[6].equals("O") && layout[7].equals("O") && layout[8].equals("O"))) {
            winner = "AI wins";
        } else if ((layout[0] != null && layout[4] != null && layout[8] != null) &&
                (layout[0].equals("O") && layout[4].equals("O") && layout[8].equals("O"))) { //O diagonal
            winner = "AI wins";
        } else if ((layout[2] != null && layout[4] != null && layout[6] != null) &&
                (layout[2].equals("O") && layout[4].equals("O") && layout[6].equals("O"))) {
            winner = "AI wins";
        } else if (checkAllFilled()) {
            winner = "Draw";
        }
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

    public void resetGame() {
        winner = "";
        gameEnded = false;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setIcon(null);
            position[i] = false;
            layout[i] = null;
        }
        for (JButton button : buttons) {
            button.setEnabled(true);
        }
    }


    public JButton getButton(int index) {
        return buttons[index];
    }

    public String getWinner() {
        return winner;
    }

    public void setGameEnded (boolean input) {
        gameEnded = input;
    }

    public boolean getGameEnded() {
        return gameEnded;
    }
}
