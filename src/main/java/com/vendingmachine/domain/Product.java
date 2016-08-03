package com.vendingmachine.domain;

import com.vendingmachine.utils.converter.ProductConverter;

import java.math.BigDecimal;

public class Product {
    private BigDecimal value;

    public boolean isEnoughCoin(BigDecimal runningTotal) {
        if (runningTotal == null) {
            return false;
        }
        return runningTotal.compareTo(this.value) >= 0;
    }

    public Product setValue(String value) {
        this.value = new ProductConverter().toProduct(value);
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Product setValue(BigDecimal value) {
        this.value = value;
        return this;
    }
}
