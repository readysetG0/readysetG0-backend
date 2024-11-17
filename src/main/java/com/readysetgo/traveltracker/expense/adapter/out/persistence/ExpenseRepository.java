package com.readysetgo.traveltracker.expense.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 비용 엔터티와 데이터베이스 간의 CRUD 작업을 수행하는 JPA 리포지토리 인터페이스입니다.
 */
public interface ExpenseRepository extends JpaRepository<ExpenseJpaEntity, Long> {

}