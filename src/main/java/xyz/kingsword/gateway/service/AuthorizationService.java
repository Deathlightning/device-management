package xyz.kingsword.gateway.service;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        subject.login(token);
        return true;
    }

    public boolean logout(User user) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return true;
    }

    public User getUserInfo(String username, String password) {
        User user = userMapper.selectByUsername(username);
        List<Role> roleList = roleMapper.selectByPrimaryKey(user.getRoleId());
        for (Role role : roleList) {
        }
        return user;
    }
}
