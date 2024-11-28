package com.readysetgo.traveltracker.category.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 카테고리 정보를 나타내는 JPA 엔터티 클래스입니다.
 * <p>
 * 데이터베이스의 `CATEGORY` 테이블과 매핑됩니다.
 * </p>
 */
@Entity
@Table(name = "CATEGORY")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 요구사항에 따라 기본 생성자 제한
public class CategoryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 카테고리 ID (Primary Key)

    private String name; // 카테고리 이름

    /**
     * 카테고리 엔터티 생성자.
     *
     * @param name 카테고리 이름
     */
    @Builder
    private CategoryJpaEntity(String name) {
        this.name = name;
    }
}