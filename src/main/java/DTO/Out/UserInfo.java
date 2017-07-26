package DTO.Out;

/**
 * Created by p on 2017/7/25.
 */
public class UserInfo {
    /**
     * userName : 名字
     * avatar : https://cdn.pixabay.com/photo/2017/07/18/18/24/dove-2516641_960_720.jpg
     * intro : 一只小老虎
     * isMale : true
     */

    private String userName;
    private String avatar;
    private String intro;
    private boolean isMale;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
