package xyz.kingsword.gateway.controller;

import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.*;
import xyz.kingsword.gateway.bean.ExceptionEnum;
import xyz.kingsword.gateway.bean.ResultBean;

@ControllerAdvice
@RestController
public class ExceptionController {
    @ExceptionHandler(UnauthenticatedException.class)
    @RequestMapping(value = "/unAuthorized", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    public Object unauthorizedException() {
        return new ResultBean<>(ExceptionEnum.UNAUTHORIZED);
    }

    @RequestMapping(value = "/unLogin", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    public Object unLogin() {
        return new ResultBean<>(ExceptionEnum.UN_LOGIN);
    }

    @RequestMapping(value = "/unknownAccount", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    public Object unknownAccount() {
        return new ResultBean<>(ExceptionEnum.UNKNOWN_ACCOUNT);
    }

    @RequestMapping(value = "/locked", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    public Object locked() {
        return new ResultBean<>(ExceptionEnum.LOCKED);
    }

    @RequestMapping(value = "/unAuthentication", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    public Object unAuthentication() {
        return new ResultBean<>(ExceptionEnum.UNKNOWN_ACCOUNT);
    }

}