package xyz.kingsword.gateway.util;

import xyz.kingsword.gateway.exception.MaxWrongTimeException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: wzh date: 2019-04-14 21:11
 * @version: 1.0
 **/
public class LoginUtil {
    private static final int MAX_WRONG_TIMES = 5;
    private static final Map<String, Integer> map = new HashMap<>(10);

    public void addWrongTime(String username) {
        map.computeIfPresent(username, (k, v) -> {
            if (map.get(username) == MAX_WRONG_TIMES) {
                throw new MaxWrongTimeException();
            }
            return map.put(k, v + 1);
        });
        map.computeIfAbsent(username, v -> map.put(v, 1));
    }

}
