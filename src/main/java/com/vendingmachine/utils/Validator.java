package com.vendingmachine.utils;

import java.math.BigDecimal;

import static com.vendingmachine.constants.Coins.NONE;
import static com.vendingmachine.constants.Products.INVALID;
import static com.vendingmachine.utils.converter.CoinConverter.toCoin;
import static com.vendingmachine.utils.converter.ProductConverter.toProduct;

public final class Validator {
    public static boolean isACoin(String value) {
        BigDecimal coin = toCoin(value);
        return !coin.equals(NONE);
    }

    public static boolean isAProduct(String value) {
        BigDecimal product = toProduct(value);
        return !product.equals(INVALID);
    }

    public static boolean isReturn(String value) {
        return "return".equalsIgnoreCase(value);
    }

    public static boolean isGreaterThanZero(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return false;
        }
        return bigDecimal.compareTo(BigDecimal.ZERO) > 0;
    }

    private Validator() { }
}
