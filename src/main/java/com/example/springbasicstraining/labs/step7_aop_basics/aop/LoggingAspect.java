package com.example.springbasicstraining.labs.step7_aop_basics.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 서비스/레포 공통 로깅
// 메서드 진입/리턴/예외/실행시간 자동 기록
//비즈니스 로직과 로깅 분리(AOP)
@Slf4j
@Aspect
@Component
public class LoggingAspect {
    //step7 패키지 하위의 서비스, 레포 전부 로깅

    @Around("execution(* com.example.springbasicstraining.labs.step7_aop_basics.service..*(..)) " +
            "|| execution(* com.example.springbasicstraining.labs.step7_aop_basics.repository..*(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        String method = pjp.getSignature().toShortString();
        log.info("▶ 실행: {}", method);
        try {
            Object result = pjp.proceed();
            log.info("✔ 완료: {} → {}", method, result);
            return result;
        } catch (Throwable ex) {
            log.warn("✘ 예외 발생: {} → {}", method, ex.toString());
            throw ex;
        }
    }
}
