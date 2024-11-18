package com.readysetgo.traveltracker.expense.adapter.out.persistence;

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
 * 비용 정보를 나타내는 JPA 엔터티 클래스입니다. 데이터베이스의 `EXPENSE` 테이블과 매핑됩니다.
 */
@Entity
@Table(name = "EXPENSE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 요구사항에 따라 기본 생성자 제한
public class ExpenseJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 비용 ID (Primary Key)

    private String billingDetails; // 결제 세부 정보

    private Double price; // 비용 금액

    /**
     * 엔터티 생성자.
     *
     * @param billingDetails 결제 세부 정보
     * @param price          비용 금액
     */
    @Builder
    private ExpenseJpaEntity(String billingDetails, Double price) {
        this.billingDetails = billingDetails;
        this.price = price;
    }

    /**
     * 비용 정보를 업데이트하는 메서드.
     *
     * @param billingDetails 새 결제 세부 정보
     * @param price          새 비용 금액
     */
    public void updateInfo(String billingDetails, Double price) {
        this.billingDetails = billingDetails;
        this.price = price;
    }
}