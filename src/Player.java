public class Player {
    private String username;
    private int followers;
    private int password;
    private int aura;

    public Player() {
        username = "";
        followers = 0;
        aura = 0;
        password = 0000;
    }

    public void addAura(int auraToAdd) {
        aura += auraToAdd;
    }

    public int getAura() {
        return aura;
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
