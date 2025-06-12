import java.util.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class Livestream {
    private Player player;
    private Timer timer;
    private boolean isTimerActive = false;
    private String[] goodChat = {"first time here!", "whoa, sick set up", "cool keyboard", "what is this stream about?",
    "you got yourself a new follower!", "im so early lolol", "can you play a horror game?", "i gtg now have a good stream!", "can i get a hi",
    "what did you eat today", "can we see your cat", "love this bro", "youre my favorite streamer"};
    private String[] badChat = {"LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL", "this dude sucks LOL", "disahdiosahdioahdiaohdaios", "LOSER",
    "HAHAHAHAHAHAHAH", "stinky streamer", "BOOOO", "follow me instead of this guy", "your ugly", "stop streaming", "reportreportreport", "yo mama",
    };

    public Livestream(Player player) {
        this.player = player;
    }

    public String getRandomGood() {
        int random = (int) (Math.random() * goodChat.length - 1);
        return goodChat[random];
    }

    public String getRandomBad() {
        int random = (int) (Math.random() * badChat.length - 1);
        return badChat[random];
    }

//    private void setupTimer() {
//        timer = new Timer(5000, e -> incrementByRandomNumber());
//    }
//
//    private void incrementByRandomNumber() {
//        int randomIncrement = (int) (Math.random() * 1001);
//        player.addFollowers(randomIncrement);
//        System.out.println("Current value of myVar: " + player.getFollowers());
//    }
//
//    public void setLoop(boolean input) {
//        loop = input;
//    }
//
//    private void switchPanel() {
//        // Stop the timer if it's active on Panel1 and switch to Panel2
//        if (isTimerActive) {
//            timer.stop();  // Stop the timer when switching
//            isTimerActive = false;
//        }
//
//        // Switch to the next panel
//        cardLayout.next(cardPanel);
//
//        // Start the timer if we are switching back to Panel1
//        if (((JLabel) ((JPanel) cardPanel.getComponent(0)).getComponent(0)).getText().contains("Timer")) {
//            timer.start();  // Start the timer if it's Panel1
//            isTimerActive = true;
//        }
//    }

}
