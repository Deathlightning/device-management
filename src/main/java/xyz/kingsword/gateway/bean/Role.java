package xyz.kingsword.gateway.bean;

import lombok.Data;

import java.util.List;

/**
 * @author: wzh date: 2019-04-14 21:34
 * @version: 1.0
 **/
@Data
public class Role {
    private List<String> permissionList;
    private int roleId;
    private String roleName;
}
