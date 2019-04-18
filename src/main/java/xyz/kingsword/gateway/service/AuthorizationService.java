package xyz.kingsword.gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.kingsword.gateway.bean.Role;
import xyz.kingsword.gateway.bean.User;
import xyz.kingsword.gateway.dao.RoleMapper;
import xyz.kingsword.gateway.dao.UserMapper;

import java.util.List;

/**
 * @author: wzh date: 2019-04-17 18:37
 * @version: 1.0
 **/
@Service
public class AuthorizationService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    public boolean login(User user) {

    }

    public User getUserInfo(String username, String password) {
        User user = userMapper.selectByUsername(username);
        List<Role> roleList = roleMapper.selectByPrimaryKey(user.getRoleId());
        for (Role role : roleList) {
        }
        return user;
    }
}
