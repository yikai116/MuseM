package dao;


import entity.Comment;

import java.util.List;

/**
 * Created by DELL on 2017-07-24.
 */
public interface CommentMapper {
    void insert(Comment c);

    void delete(int id);

    List<Comment> getAllByArtId(int artId);

    Comment selectByCmtId(int cmtId);

}
