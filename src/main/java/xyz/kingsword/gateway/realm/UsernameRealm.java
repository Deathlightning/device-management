package xyz.kingsword.gateway.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import xyz.kingsword.gateway.bean.User;
import xyz.kingsword.gateway.dao.RoleMapper;
import xyz.kingsword.gateway.dao.UserMapper;
import xyz.kingsword.gateway.util.LoginUtil;
import xyz.kingsword.gateway.util.SpringContextUtil;

import java.util.Optional;
import java.util.Set;

/**
 * @author: wzh date: 2019-04-14 21:33
 * @version: 1.0
 **/
//实现AuthorizingRealm接口用户用户认证
public class UsernameRealm extends AuthorizingRealm {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    //用户鉴权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Cache<Object, AuthenticationInfo> cache = super.getAuthenticationCache();
        AuthenticationInfo authorizationInfo = cache.get("username");
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //查询用户名称
        User user = (User) Optional.ofNullable(null).orElseThrow(UnknownAccountException::new);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(user.getRoleSet());
        simpleAuthorizationInfo.addStringPermissions(user.getUrlSet());
        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户信息
        String username = authenticationToken.getPrincipal().toString();
        String password = new String((char[]) authenticationToken.getCredentials());
        User user = userMapper.authentication(username, password);
        Optional.ofNullable(user).orElseThrow(() -> {
            LoginUtil.addWrongTime(username);
            throw new AuthenticationException();
        });
        Set<String> urlSet = roleMapper.selectUrl(user.getId());
        user.setUrlSet(urlSet);

        return new SimpleAuthenticationInfo(getName(), user.getPassword().toString(), getName());
    }
}
