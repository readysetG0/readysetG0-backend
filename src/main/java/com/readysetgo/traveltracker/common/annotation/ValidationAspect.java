package com.readysetgo.traveltracker.common.annotation;

import com.readysetgo.traveltracker.common.util.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Lombok의 빌더 메서드가 호출될 때, {@link BuilderValidator} 어노테이션이 적용된 클래스의 객체에 대해 유효성 검사를 수행하는 AOP 클래스입니다.
 */
@Aspect
@Component
@Slf4j
public class ValidationAspect {

    /**
     * 빌더 메서드를 대상으로 하는 포인트컷 정의
     * <p>build() 메서드를 실행 대상으로 설정합니다.</p>
     */
    @Pointcut("execution(* com.readysetgo.traveltracker..*.build(..))")
    public void builderMethodExecution() {
    }

    /**
     * 빌더 메서드 실행 시 유효성 검사를 수행하는 어드바이스
     * <p>빌더 메서드를 호출할 때, 해당 메서드가 소속된 외부 클래스에 {@link BuilderValidator} 어노테이션이 존재하는지 확인하고,
     * 유효성 검사를 수행합니다.</p>
     *
     * @param joinPoint 빌더 메서드의 실행 지점
     * @return 유효성 검사 후 생성된 객체
     * @throws Throwable 유효성 검사 실패 시 발생하는 예외
     */
    @Around("builderMethodExecution()")
    public Object validateBuilderMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // 빌더의 외부 클래스가 @BuilderValidator 어노테이션을 가지고 있는지 확인
        if (isParentClassAnnotatedWithBuilderValidator(joinPoint)) {
            // INFO: 유효성 검사를 시작하며, 대상 클래스만 출력
            Class<?> parentClass = joinPoint.getTarget().getClass().getEnclosingClass();
            log.info("유효성 검사를 시작합니다 - 대상 클래스: {}",
                parentClass != null ? parentClass.getName() : "알 수 없는 클래스");

            // build() 메서드를 호출하여 객체 생성
            Object builtObject = joinPoint.proceed();

            // 유효성 검사 수행
            ValidationUtils.validate(builtObject);

            // INFO: 유효성 검사 완료 로그 출력
            log.info("유효성 검사 완료 - 대상 객체: {}", builtObject);
            return builtObject;
        }

        // DEBUG: 어노테이션이 없는 경우 로그 출력
        log.debug("유효성 검사가 필요하지 않은 클래스에서 build()가 호출되었습니다 - 메서드: {}", joinPoint.getSignature());
        return joinPoint.proceed();
    }

    /**
     * 빌더의 외부 클래스가 {@link BuilderValidator} 어노테이션을 가지고 있는지 확인합니다.
     *
     * @param joinPoint 빌더 메서드의 실행 지점
     * @return 외부 클래스가 @BuilderValidator 어노테이션을 가지고 있으면 true, 그렇지 않으면 false
     */
    private boolean isParentClassAnnotatedWithBuilderValidator(ProceedingJoinPoint joinPoint) {
        Class<?> builderClass = joinPoint.getTarget().getClass();
        Class<?> parentClass = builderClass.getEnclosingClass();

        // 외부 클래스가 @BuilderValidator 어노테이션을 가지고 있는지 확인
        return parentClass != null && parentClass.isAnnotationPresent(BuilderValidator.class);
    }
}