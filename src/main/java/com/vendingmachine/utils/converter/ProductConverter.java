package com.vendingmachine.utils.converter;

import java.math.BigDecimal;

import static com.vendingmachine.constants.Products.*;

public final class ProductConverter {
    public static BigDecimal toProduct(String entry) {
        if ("cola".equalsIgnoreCase(entry)) {
            return COLA;
        } else if ("chips".equalsIgnoreCase(entry)) {
            return CHIPS;
        } else if ("candy".equalsIgnoreCase(entry)) {
            return CANDY;
        } else {
            return INVALID;
        }
    }

    private ProductConverter() { }
}
