package inventorymanagmentsystem;

/**
 *
 * @author Muhammed
 */
public class user {

    private String username;
    private String password;
    private int wearhouseID;
    private int premission;

    user(String user, String password_s, int id, int p) {
        this.username = user;
        this.wearhouseID = id;
        this.premission = p;
        this.password = password_s;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWearhouseID() {
        return wearhouseID;
    }

    public void setWearhouseID(int wearhouseID) {
        this.wearhouseID = wearhouseID;
    }

    public int getPremission() {
        return premission;
    }

    public void setPremission(int premission) {
        this.premission = premission;
    }


}
