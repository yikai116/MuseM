package DAO.Entity;

/**
 * Created by DELL on 2017-07-24.
 */
public class Type {
    private String user;

    private String type;

    public Type(String user, String type) {
        this.user = user;
        this.type = type;
    }

    public Type() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
