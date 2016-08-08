package com.vendingmachine.domain;

import java.math.BigDecimal;

import static com.vendingmachine.utils.converter.ProductConverter.toProduct;

public class Product {
    private final BigDecimal value;

    public Product(final BigDecimal value) {
        this.value = value;
    }

    public Product(final String value) {
        this.value = toProduct(value);
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
