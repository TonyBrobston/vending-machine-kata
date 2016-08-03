package com.vendingmachine.utils;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import com.vendingmachine.utils.Validator;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class ValidatorTest {
    @DataProvider
    public static Object[][] coinDataProvider() {
        return new Object[][] {
                { "nickel", true },
                { "dime", true },
                { "chips", false }
        };
    }

    @Test
    @UseDataProvider("coinDataProvider")
    public void shouldPassIfIsValidCoin(String value, boolean expected) {
        assertEquals(expected, new Validator().isACoin(value));
    }

    @DataProvider
    public static Object[][] productDataProvider() {
        return new Object[][] {
                { "chips", true },
                { "candy", true },
                { "dime", false }
        };
    }

    @Test
    @UseDataProvider("productDataProvider")
    public void shouldPassIfIsValidProduct(String value, boolean expected) {
        assertEquals(expected, new Validator().isAProduct(value));
    }

    @DataProvider
    public static Object[][] returnDataProvider() {
        return new Object[][] {
                { "return", true },
                { "Return", true },
                { "", false },
                { null, false }
        };
    }

    @Test
    @UseDataProvider("returnDataProvider")
    public void shouldPassIfIsReturn(String value, boolean expected) {
        assertEquals(expected, new Validator().isReturn(value));
    }

    @DataProvider
    public static Object[][] isGreaterThanZeroDataProvider() {
        return new Object[][] {
                { BigDecimal.ONE, true },
                { BigDecimal.ZERO, false },
                { null, false }
        };
    }

    @Test
    @UseDataProvider("isGreaterThanZeroDataProvider")
    public void shouldPassIfIsGreaterThanZero(BigDecimal bigDecimal, boolean expected) {
        assertEquals(expected, new Validator().isGreaterThanZero(bigDecimal));
    }


}
