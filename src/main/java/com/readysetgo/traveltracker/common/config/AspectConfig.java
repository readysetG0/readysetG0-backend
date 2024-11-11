package com.readysetgo.traveltracker.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 애플리케이션의 AOP 설정을 활성화하는 설정 클래스입니다.
 * <p>
 * 이 클래스는 AspectJ 스타일의 AOP 기능을 사용하기 위해 {@link EnableAspectJAutoProxy} 어노테이션을 활성화하여 프록시 기반의 AOP를
 * 설정합니다.
 * </p>
 * <p>
 * `proxyTargetClass` 속성을 `true`로 설정하여 CGLIB 프록시를 강제로 사용하게 하며, 인터페이스가 없는 클래스에도 AOP 기능을 적용할 수 있도록
 * 지원합니다.
 * </p>
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true) // AspectJ 스타일 AOP 설정을 활성화
public class AspectConfig {

}