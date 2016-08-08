package com.vendingmachine.utils;

import java.math.BigDecimal;
import java.text.NumberFormat;

public final class Formatter {
    public static String toCurrency(BigDecimal bigDecimal) {
        return NumberFormat.getCurrencyInstance().format(bigDecimal);
    }

    private Formatter() { }
}
