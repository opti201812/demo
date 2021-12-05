package com.example.demo.conf;

import com.example.demo.annotation.Function;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.logging.Logger;

@Configuration
@Aspect
public class RoleAccessConfig {
    //private static final Logger logger = (Logger) LoggerFactory.getLogger(RoleAccessConfig.class);

    @Around("within(@org.springframework.stereotype.Controller *) && @annotation(function)")
    public Object functionAccessCheck(final ProceedingJoinPoint pjp, Function function) throws Throwable {
//        if (function != null) {
//            String functionName = function.value();
//            if (!canAccess(functionName)) {
//                MethodSignature ms = (MethodSignature) pjp.getSignature();
//                throw new RuntimeException("Can not access " + ms.getMethod());
//            }
//        }

        Object o = pjp.proceed();
        return o;
    }

    protected boolean canAccess(String functionName) {
        if (functionName.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Around("@within(org.springframework.stereotype.Controller)")
    public Object simpleAop(final ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object[] args = pjp.getArgs();

            System.out.println("args: " + Arrays.asList(args));
            Object o = pjp.proceed();
            System.out.println("return: " + o);

            return o;
        } catch (Throwable e) {
            throw e;
        }
    }
}
