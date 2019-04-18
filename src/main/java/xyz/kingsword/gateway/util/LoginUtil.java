package xyz.kingsword.gateway.util;

import org.apache.shiro.authc.AuthenticationException;
import xyz.kingsword.gateway.bean.User;
import xyz.kingsword.gateway.dao.RoleMapper;
import xyz.kingsword.gateway.dao.UserMapper;
import xyz.kingsword.gateway.exception.MaxWrongTimeException;

import java.util.*;

/**
 * @author: wzh date: 2019-04-14 21:11
 * @version: 1.0
 **/
public class LoginUtil {
    private static final int MAX_WRONG_TIMES = 5;
    private static final Map<String, Integer> map = new HashMap<>(10);

    public static void addWrongTime(String username) {
        map.computeIfPresent(username, (k, v) -> {
            if (map.get(username) == MAX_WRONG_TIMES) {
                throw new MaxWrongTimeException();
            }
            return map.put(k, v + 1);
        });
        map.computeIfAbsent(username, v -> map.put(v, 1));
    }

    public User authentication(String username, String password) {
        UserMapper userMapper = SpringContextUtil.getBean(UserMapper.class);
        assert userMapper!=null;
        Optional<User> userOptional = Optional.ofNullable(userMapper.authentication(username, password));
        RoleMapper roleMapper = SpringContextUtil.getBean(RoleMapper.class);
        User user = userOptional.orElseThrow(AuthenticationException::new);
        Set<String> urlSet = roleMapper.selectUrl(user.getId());
        user.setUrlSet(urlSet);
        return user;
    }

}
