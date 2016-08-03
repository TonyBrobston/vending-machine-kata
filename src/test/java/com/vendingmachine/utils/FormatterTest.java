package com.vendingmachine.utils;

import com.vendingmachine.utils.Formatter;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    @Test
    public void shouldFormatMoney() {
        assertEquals("$13.37", new Formatter().toCurrency(new BigDecimal(13.37)));
    }
}
