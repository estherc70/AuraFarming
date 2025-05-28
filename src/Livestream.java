import java.util.ArrayList;

public class Livestream {
    private String[] goodChat = {"first time here!", "whoa, sick set up", "cool keyboard", "what is this stream about?",
    "you got yourself a new follower!", "im so early lolol", "can you play a horror game?", "i gtg now have a good stream!"};
    private String[] badChat = {"LLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL", "this dude sucks LOL", "disahdiosahdioahdiaohdaios", "LOSER",
    "HAHAHAHAHAHAHAH", "stinky streamer", "BOOOO"};
    private String[] currentChat;
    private int chatNum;

    public Livestream() {
        currentChat = new String[10];
        chatNum = 0;
    }

    public boolean checkInBounds() {
        return chatNum < currentChat.length;
    }

    public String getRandomGood() {
        int random = (int) (Math.random() * goodChat.length - 1);
        return goodChat[random];
    }

    public String getRandomBad() {
        int random = (int) (Math.random() * badChat.length - 1);
        return badChat[random];
    }

    public void moveChatUp() {
        for (int i = 0; i < currentChat.length - 1; i++) {
            String temp = currentChat[i+2];
            currentChat[i] = currentChat[i+1];
            currentChat[i+1] = temp;
        }
    }

    public String[] getCurrentChat() {
        return currentChat;
    }

    public int getChatNum() {
        return chatNum;
    }

    public void setChatNum(int num) {
        chatNum = num;
    }

    public void incrementChatNum() {
        chatNum++;
    }

    public void setCurrentChat(int index, String str) {
        currentChat[index] = str;
    }
}
