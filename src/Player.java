public class Player {
    private String username;
    private int followers;

    public Player() {
        username = "";
        followers = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUser) {
        username = newUser;
    }

    public int getFollowers() {
        return followers;
    }

    public void addFollowers(int newFollowers) {
        followers = followers + newFollowers;
    }

}
