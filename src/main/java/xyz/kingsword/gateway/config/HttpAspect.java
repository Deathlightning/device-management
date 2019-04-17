package xyz.kingsword.gateway.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class HttpAspect {

    @Pointcut("execution(* xyz.kingsword.gateway.controller..*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = point.proceed();
        System.out.println(666);
        return JSON.toJSONString(result);
    }

    @AfterReturning(pointcut = "log()", returning = "parameter") // 打印输出结果
    public void doAfterReturning(Object parameter) {
    }

    @After("log()")
    public void after() {
    }
}
