package dto.Out;

import java.util.List;

/**
 * Created by p on 2017/7/25.
 */
public class UserInfo {
    /**
     * userName : 名字
     * avatar : https://cdn.pixabay.com/photo/2017/07/18/18/24/dove-2516641_960_720.jpg
     * intro : 一只小老虎
     * isMale : true
     * artNum" : 5,
     * typeNum": 2
     * stars": ["","",""]
     */

    private String userName;
    private String avatar;
    private String intro;
    private String isMale;
    private int artNum;
    private int typeNum;
    private List<String> stars;

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

    public String getIsMale() {
        return isMale;
    }

    public void setIsMale(String isMale) {
        this.isMale = isMale;
    }

    public int getArtNum() {
        return artNum;
    }

    public void setArtNum(int artNum) {
        this.artNum = artNum;
    }

    public int getTypeNum() {
        return typeNum;
    }

    public void setTypeNum(int typeNum) {
        this.typeNum = typeNum;
    }

    public List<String> getStars() {
        return stars;
    }

    public void setStars(List<String> stars) {
        this.stars = stars;
    }
}
