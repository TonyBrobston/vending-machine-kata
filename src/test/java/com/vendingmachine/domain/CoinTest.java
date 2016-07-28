package com.vendingmachine.domain;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static com.vendingmachine.constants.Coins.*;

@RunWith(DataProviderRunner.class)
public class CoinTest {
    @DataProvider
    public static Object[][] coinDataProvier() {
        return new Object[][] {
                { NICKEL, true },
                { DIME, true },
                { QUARTER, true },
                { PENNY, false },
                { null, false }
        };
    }

    @Test
    @UseDataProvider("coinDataProvier")
    public void shouldPassIfIsValidCoin(Integer value, boolean expected) {
        assertEquals(expected, new Coin().setValue(value).isValid());
    }

    @DataProvider
    public static Object[][] coinConverterDataProvier() {
        return new Object[][] {
                { "nickel", NICKEL },
                { "1", PENNY }
        };
    }

    @Test
    @UseDataProvider("coinConverterDataProvier")
    public void shouldConvertStringsToIntegerInSetter(String in, Integer out) {
        assertEquals(out, new Coin().setValue(in).getValue());
    }
}