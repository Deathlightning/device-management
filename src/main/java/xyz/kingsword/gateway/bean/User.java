package xyz.kingsword.gateway.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: wzh date: 2019-04-14 21:33
 * @version: 1.0
 **/
@Data
public class User implements Serializable {
    private String username;
    @JSONField(serialize = false)
    private String password;
    private List<String> permissionList;
    private List<Role> roleList;
}
