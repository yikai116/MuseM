package dao;

import java.util.List;

/**
 * Created by p on 2017/7/24.
 */
public interface StarMapper {
    void insert(String hostEmail, String friendEmail);
    void delete(String hostEmail, String friendEmail);
    int find(String hostEmail, String friendEmail);
    List<String> getStars(String hostEmail);
}
