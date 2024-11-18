package com.readysetgo.traveltracker.category.application.port.in;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

/**
 * 카테고리 생성 비즈니스 로직에 필요한 데이터를 전달하는 명령 객체입니다.
 */
@Builder
public record CreateCategoryCommand(
    @NotEmpty String name // 카테고리 이름
) {

}