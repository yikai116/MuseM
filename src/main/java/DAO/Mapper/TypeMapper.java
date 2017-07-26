package DAO.Mapper;

import DAO.Entity.Type;

import java.util.List;

/**
 * Created by DELL on 2017-07-24.
 */
public interface TypeMapper {
    void insert(Type t);

    void delete(Type t);

    List<Type> getType(String email);

    int isExist(Type t);

    int getTypeNum(String email);
}
