package dto.Out;

import entity.Comment;

import java.sql.Date;

/**
 * Created by DELL on 2017-07-25.
 */
public class CommentResult{
    private String cmterName;
    private String cmter;
    private int cmtId;
    private int artId;
    private Date createDate;
    private String cmtContent;

    public CommentResult() {
    }

    public CommentResult(Comment c, String cmterName) {
        this.cmterName = cmterName;
        this.cmter = c.getCmter();
        this.cmtId = c.getCmtId();
        this.artId = c.getArtId();
        this.createDate = c.getCreateDate();
        this.cmtContent = c.getCmtContent();
    }
    public CommentResult(String cmterName, String cmter, int cmtId, int artId, Date createDate, String cmtContent) {
        this.cmterName = cmterName;
        this.cmter = cmter;
        this.cmtId = cmtId;
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

    public String getCmterName() {
        return cmterName;
    }

    public void setCmterName(String cmterName) {
        this.cmterName = cmterName;
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
