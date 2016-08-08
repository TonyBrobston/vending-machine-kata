package com.vendingmachine.domain;

import com.vendingmachine.utils.converter.ProductConverter;

import java.math.BigDecimal;

public class Product {
    private final BigDecimal value;

    public Product(final BigDecimal value) {
        this.value = value;
    }

    public Product(final String value) {
        this.value = ProductConverter.toProduct(value);
    }

    public boolean isEnoughCoin(BigDecimal runningTotal) {
        if (runningTotal == null) {
            return false;
        }
        return runningTotal.compareTo(this.value) >= 0;
    }

    public BigDecimal getValue() {
        return value;
    }
}
