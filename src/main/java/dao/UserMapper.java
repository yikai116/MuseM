package dao;

import entity.User;

import java.sql.Date;

/**
 * Created by p on 2017/7/20.
 */
public interface UserMapper {
    void insert(User user);
    User findByEmail(String Email);
    User findByToken(String token);
    void updateToken(String email, String token, Date expiredDate);
    void updateInfo(User user);
}
