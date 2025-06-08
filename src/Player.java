public class Player {
    private String username;
    private int followers;
    private int password;
    private int aura;
    private int ads;
    public Player() {
        username = "";
        followers = 0;
        aura = 0;
        ads = 0;
        password = 0000;
    }

    public int addAura() {
        int auraToAdd = (int) (Math.random() * 1001);
        aura += auraToAdd;
        return auraToAdd;
    }

    public int deleteAura() {
        int auraToDelete = (int) (Math.random() * 101);
        aura -= auraToDelete;
        return auraToDelete;
    }

    public int getAura() {
        return aura;
    }

    public void addAds(int add) {
        ads += add;
    }

    public int getAds() {
        return ads;
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
