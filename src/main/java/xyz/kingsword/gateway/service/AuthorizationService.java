package xyz.kingsword.gateway.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import xyz.kingsword.gateway.bean.User;

/**
 * @author: wzh date: 2019-04-17 18:37
 * @version: 1.0
 **/
@Service
public class AuthorizationService {
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
}
