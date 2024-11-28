package com.readysetgo.traveltracker.category.domain;

import lombok.Builder;
import lombok.Getter;

/**
 * 카테고리를 나타내는 도메인 클래스입니다.
 * <p>
 * 비즈니스 로직과 밀접하게 연관된 데이터를 표현하며, 데이터베이스 엔터티와 분리된 형태로 사용됩니다.
 * </p>
 */
@Getter
public class Category {

    private final String name; // 카테고리 이름
    private Long id;           // 카테고리 ID

    /**
     * 카테고리 객체 생성자.
     *
     * @param name 카테고리 이름
     * @param id   카테고리 ID
     */
    @Builder
    private Category(String name, Long id) {
        this.name = name;
        this.id = id;
    }
}