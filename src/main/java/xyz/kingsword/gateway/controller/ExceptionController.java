package xyz.kingsword.gateway.controller;

import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.springframework.web.bind.annotation.*;
import xyz.kingsword.gateway.aop.ExceptionEnum;
import xyz.kingsword.gateway.aop.ResultBean;
import xyz.kingsword.gateway.exception.MaxWrongTimeException;

@ControllerAdvice
@RestController
public class ExceptionController {
    @ExceptionHandler(UnauthenticatedException.class)
    @RequestMapping(value = "/unAuthorization", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
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

    @ExceptionHandler(value = LockedAccountException.class)
    @RequestMapping(value = "/locked", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    public Object locked() {
        return new ResultBean<>(ExceptionEnum.LOCKED);
    }

    @RequestMapping(value = "/unAuthentication", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    public Object unAuthentication() {
        return new ResultBean<>(ExceptionEnum.UNKNOWN_ACCOUNT);
    }

    @ExceptionHandler(MaxWrongTimeException.class)
    @RequestMapping(value = "/maxWrongTime", method = RequestMethod.GET, produces = "application/json;charset:utf-8")
    public Object MaxWrongTimeController() {
        return new ResultBean<>(ExceptionEnum.MAX_WRONG_TIMES);
    }

}
