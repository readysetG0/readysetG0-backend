package com.readysetgo.traveltracker.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 롬복 {@link lombok.Builder} 어노테이션과 함께 사용하여 빌더 패턴으로 생성된 객체의 유효성 검사를 수행하는 어노테이션입니다.
 * <p>
 * 이 어노테이션이 클래스나 레코드에 적용되면, {@link com.readysetgo.traveltracker.common.util.ValidationUtils}를 통해 빌더
 * 메서드 실행 시 유효성 검사가 자동으로 수행됩니다.
 * </p>
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BuilderValidator {

}