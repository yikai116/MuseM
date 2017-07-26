package DAO.Mapper;

import DAO.Entity.Article;

import java.util.List;

/**
 * Created by DELL on 2017-07-24.
 */
public interface ArticleMapper {
    void insert(Article a);

    void update(Article a);

    void delete(int id);

    Article getArticleById(int id);

    List<Article> getArticlesByEmail(String email);

    int getArtNum(String email);

    List<Article> getArticlesByEmailType(String email, String type);

}
