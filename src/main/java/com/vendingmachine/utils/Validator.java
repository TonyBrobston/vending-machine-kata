package com.vendingmachine.utils;

import com.vendingmachine.utils.converter.CoinConverter;
import com.vendingmachine.utils.converter.ProductConverter;

import java.math.BigDecimal;

import static com.vendingmachine.constants.Coins.NONE;
import static com.vendingmachine.constants.Products.INVALID;

public final class Validator {
    public static boolean isACoin(String value) {
        BigDecimal coin = CoinConverter.toCoin(value);
        return !coin.equals(NONE);
    }

    public static boolean isAProduct(String value) {
        BigDecimal product = ProductConverter.toProduct(value);
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
