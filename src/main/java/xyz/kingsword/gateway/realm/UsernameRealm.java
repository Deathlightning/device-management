package xyz.kingsword.gateway.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.kingsword.gateway.bean.User;
import xyz.kingsword.gateway.dao.UserMapper;

import java.util.Optional;

/**
 * @author: wzh date: 2019-04-14 21:33
 * @version: 1.0
 **/
//实现AuthorizingRealm接口用户用户认证
public class UsernameRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        User user = (User) Optional.ofNullable(null).orElseThrow(UnknownAccountException::new);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        user.getRoleList().forEach(v -> simpleAuthorizationInfo.addRole(v.getRoleName()));
        simpleAuthorizationInfo.addStringPermissions(user.getPermissionList());
        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户信息
        String username = authenticationToken.getPrincipal().toString();
        User user = userMapper.selectByPrimaryKey(username);
        user = Optional.ofNullable(user).orElseThrow(UnknownAccountException::new);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(getName(), user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
        return null;
    }
}
