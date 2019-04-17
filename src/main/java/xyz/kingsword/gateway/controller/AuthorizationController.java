package xyz.kingsword.gateway.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.kingsword.gateway.bean.User;

/**
 * @author: wzh date: 2019-04-17 18:34
 * @version: 1.0
 **/
@RestController
public class AuthorizationController {
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json;charset:utf-8")
    public Object login(@RequestBody User user) {

    }
}
