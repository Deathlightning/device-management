package xyz.kingsword.gateway.dao;

import xyz.kingsword.gateway.bean.Role;

import java.util.List;
import java.util.Set;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> collectByUser(int userId);

    Set<String> selectUrl(int userId);
}