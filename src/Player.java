public class Player {
    private String username;
    private int followers;
    private int password;
    private int aura;
    private int ads;
    private int current;
    private int currentAura;
    public Player() {
        username = "";
        followers = 0;
        aura = 0;
        ads = 0;
        current = 0;
        currentAura = 0;
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

    public void deleteAura(int amount) {
        aura -= amount;
    }

    public void setCurrent(int set) {
        current = set;
    }

    public void setCurrentAura(int amount) {
        currentAura = amount;
    }

    public int getAura() {
        return aura;
    }

    public void addAds(int add) {
        ads += add;
    }

    public int getCurrent() {
        return current;
    }

    public int getCurrentAura() {
        return currentAura;
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
