package entity;

import java.sql.Date;

/**
 * Created by DELL on 2017-07-24.
 */
public class Comment {
    private int cmtId;
    private String cmter;
    private int artId;
    private Date createDate;
    private String cmtContent;

    public Comment() {
    }

    public Comment(String cmter, int artId, Date createDate, String cmtContent) {
        this.cmter = cmter;
        this.artId = artId;
        this.createDate = createDate;
        this.cmtContent = cmtContent;
    }

    public String getCmter() {
        return cmter;
    }

    public void setCmter(String cmter) {
        this.cmter = cmter;
    }

    public int getCmtId() {
        return cmtId;
    }

    public void setCmtId(int cmtId) {
        this.cmtId = cmtId;
    }

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }
}
