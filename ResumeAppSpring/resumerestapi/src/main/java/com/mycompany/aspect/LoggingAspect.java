package com.mycompany.aspect;

import com.mycompany.entity.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {

    @Before(value = "execution(* com.mycompany.dao.impl.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("before advice started");
        System.out.println(joinPoint.getSignature());
        System.out.println("before advice finished");
        System.out.println("**********************");
    }

    @Before(value = "execution(* com.mycompany.dao.impl.UserRepositoryCustom.filter(..))")
    public void beforeAdviceUser(JoinPoint joinPoint) {
        System.out.println("before advice started2");
        System.out.println(joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
        System.out.println("before advice finished");
        System.out.println("**********************");
    }

    @After(value = "execution(* com.mycompany.dao.impl.*.*(..)))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("after advice started");
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("after advice finished");
        System.out.println("**********************");
    }

    @Around(value = "execution(* com.mycompany.dao.impl.*.*(..)))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around advice started");
        System.out.println("around");
        Object obj = joinPoint.proceed();
        System.out.println("around advice finished");
        System.out.println("**********************");
        return obj;
    }

    @AfterReturning(
            value = "execution(* com.mycompany.dao.impl.UserRepositoryCustom.getAll(..)))",
            returning = "users")
    public void afterReturningAdvice(JoinPoint joinPoint, List<User> users) {
        System.out.println("after returning advice started");
        System.out.println("After Returning method:"+joinPoint.getSignature());
        System.out.println(users);
        System.out.println("after returning advice finished");
        System.out.println("**********************");
    }

}
