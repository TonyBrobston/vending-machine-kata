package com.vendingmachine.formatter;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Formatter {
    public String toCurrency(BigDecimal bigDecimal) {
        return NumberFormat.getCurrencyInstance().format(bigDecimal);
    }
}
