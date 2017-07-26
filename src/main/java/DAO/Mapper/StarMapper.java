package DAO.Mapper;

/**
 * Created by p on 2017/7/24.
 */
public interface StarMapper {
    void insert(String hostId, String friendId);
    void delete(String hostId, String friendId);
    int find(String hostId, String friendId);
}
