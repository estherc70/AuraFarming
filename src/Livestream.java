import java.util.ArrayList;

public class Livestream {
    private String[] goodChat = {"first time here!", "whoa, sick set up", "cool keyboard", "what is this stream about?",
    "you got yourself a new follower!", "im so early lolol", "can you play a horror game?", "i gtg now have a good stream!", "can i get a hi",
    "what did you eat today", "can we see your cat", "love this bro", "youre my favorite streamer"};
    private String[] badChat = {"LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL", "this dude sucks LOL", "disahdiosahdioahdiaohdaios", "LOSER",
    "HAHAHAHAHAHAHAH", "stinky streamer", "BOOOO", "follow me instead of this guy", "your ugly", "stop streaming", "reportreportreport", "yo mama",
    };

    public Livestream() {
    }

    public String getRandomGood() {
        int random = (int) (Math.random() * goodChat.length - 1);
        return goodChat[random];
    }

    public String getRandomBad() {
        int random = (int) (Math.random() * badChat.length - 1);
        return badChat[random];
    }
}
