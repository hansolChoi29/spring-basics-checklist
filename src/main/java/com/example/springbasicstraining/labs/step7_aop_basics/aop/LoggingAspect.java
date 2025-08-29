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

//AOP = 관점 지향 프로그래밍
// 흩어진 공통 기능(로깅, 트랜잭션, 보안 등)을 따로 모아서 관리하는 기술
// 덕분에 핵심로직(비즈니스)과 부가기능(로깅 등)을 분리할 수 있음

// AOP는 코드에 매번 붙여야 하는 부가 기능을 자동으로 끼워주는 조력자


