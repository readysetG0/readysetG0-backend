package com.readysetgo.traveltracker.expense.domain;

import static lombok.AccessLevel.PRIVATE;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = PRIVATE)
@Builder
public class Expense {

    private final String billingDetails;
    private final Double price;
    ;
    private Long id;
}