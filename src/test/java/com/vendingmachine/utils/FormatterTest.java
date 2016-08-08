package com.vendingmachine.utils;

import org.junit.Test;

import java.math.BigDecimal;

import static com.vendingmachine.utils.Formatter.toCurrency;
import static org.junit.Assert.assertEquals;

public class FormatterTest {
    @Test
    public void shouldFormatMoney() {
        assertEquals("$13.37", toCurrency(new BigDecimal(13.37)));
    }
}
