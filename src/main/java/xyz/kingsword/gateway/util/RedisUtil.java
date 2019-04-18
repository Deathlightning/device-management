package xyz.kingsword.gateway.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import xyz.kingsword.gateway.bean.User;

/**
 * @author: wzh date: 2019-04-18 13:30
 * @version: 1.0
 **/
public class RedisUtil {
    @Autowired
    private static RedisTemplate<String, Object> redisTemplate;

    public static void put(User user) {
        HashOperations<String, String, User> hashOperations = redisTemplate.opsForHash();
        hashOperations.put("authenticationed", user.getUsername(), user);
    }

    public static User getUser(String username) {
        HashOperations<String, String, User> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get("authenticationed", username);
    }
}
