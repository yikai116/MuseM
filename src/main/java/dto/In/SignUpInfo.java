package dto.In;

/**
 * Created by p on 2017/7/21.
 */
public class SignUpInfo {

    /**
     * userName : name
     * email : xxx.@xx.com
     * password : 123456
     * intro : 我真他妈的聪明
     * isMale : true
     */

    private String userName;
    private String email;
    private String password;
    private String intro;
    private boolean isMale;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public boolean isIsMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

}