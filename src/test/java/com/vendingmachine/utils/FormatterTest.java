package com.vendingmachine.utils;

import com.vendingmachine.utils.Formatter;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    @Test
    public void shouldFormatMoney() {
        BigDecimal bigDecimal = new BigDecimal(13.37);

        String currency = new Formatter().toCurrency(bigDecimal);

        assertEquals("$13.37", currency);
    }
}
