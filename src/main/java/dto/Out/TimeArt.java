package dto.Out;

import java.sql.Date;
/**
 * Created by p on 2017/7/27.
 */
public class TimeArt {
    /**
     * artId :
     * artTitle :
     * time : 2017-07-26
     * artContent :
     */

    private int artId;
    private String artTitle;
    private Date time;
    private String artContent;

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }
}
