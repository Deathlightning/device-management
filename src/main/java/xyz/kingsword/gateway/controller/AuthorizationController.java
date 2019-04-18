package xyz.kingsword.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.kingsword.gateway.bean.ResultBean;
import xyz.kingsword.gateway.bean.User;
import xyz.kingsword.gateway.service.AuthorizationService;

/**
 * @author: wzh date: 2019-04-17 18:34
 * @version: 1.0
 **/
@RestController
public class AuthorizationController {
    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset:utf-8")
    public Object login(@RequestBody User user) {
        authorizationService.login(user);
        return new ResultBean<>();
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET, params = "application/json;charset:utf-8")
    public Object logout(@RequestBody User user) {
        authorizationService.logout(user);
        return new ResultBean<>();
    }
}
