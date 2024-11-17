package com.readysetgo.traveltracker.debtor.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 채무자 정보를 나타내는 JPA 엔터티 클래스입니다. 데이터베이스의 `DEBTOR` 테이블과 매핑됩니다.
 */
@Entity
@Table(name = "DEBTOR")
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC) // TODO: 추후 필드 추가에 따른 JPA 요구사항에 따라 기본 생성자 제한
public class DebtorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 채무자 ID (Primary Key)

}