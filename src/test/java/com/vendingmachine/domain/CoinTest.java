package com.vendingmachine.domain;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static com.vendingmachine.constants.Coins.*;

@RunWith(DataProviderRunner.class)
public class CoinTest {
    @DataProvider
    public static Object[][] coinDataProvider() {
        return new Object[][] {
                { NICKEL, true },
                { DIME, true },
                { QUARTER, true },
                { PENNY, false },
                { null, false }
        };
    }

    @Test
    @UseDataProvider("coinDataProvider")
    public void shouldPassIfIsValidCoin(BigDecimal value, boolean expected) {
        assertEquals(expected, new Coin().setValue(value).isValidForUse());
    }

    @DataProvider
    public static Object[][] coinConverterDataProvier() {
        return new Object[][] {
                { "nickel", NICKEL },
                { ".01", PENNY }
        };
    }

    @Test
    @UseDataProvider("coinConverterDataProvier")
    public void shouldConvertStringsToBigDecimalInSetter(String in, BigDecimal out) {
        assertEquals(out, new Coin().setValue(in).getValue());
    }
}