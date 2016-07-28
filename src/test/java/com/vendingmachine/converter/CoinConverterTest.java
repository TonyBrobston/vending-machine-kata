package com.vendingmachine.converter;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static com.vendingmachine.constants.Coins.*;

@RunWith(DataProviderRunner.class)
public class CoinConverterTest {
    @DataProvider
    public static Object[][] toCoinDataProvier() {
        return new Object[][] {
                { "Penny", PENNY },
                { "penny", PENNY },
                { "Nickel", NICKEL },
                { "Dime", DIME },
                { "Quarter", QUARTER },
                { "Half dollar", HALF_DOLLAR },
                { "Halfdollar", HALF_DOLLAR },
                { ".01", PENNY },
                { ".05", NICKEL },
                { ".10", DIME },
                { ".1", DIME },
                { ".25", QUARTER },
                { ".50", HALF_DOLLAR },
                { ".5", HALF_DOLLAR },
                { "0.01", PENNY },
                { "0.05", NICKEL },
                { "0.10", DIME },
                { "0.1", DIME },
                { "0.25", QUARTER },
                { "0.50", HALF_DOLLAR },
                { "0.5", HALF_DOLLAR },
                { "", NONE},
                { "asdf", NONE}
        };
    }

    @Test
    @UseDataProvider("toCoinDataProvier")
    public void shouldConvertStringToBigDecimal(String entry, BigDecimal expected) {
        assertEquals(expected, new CoinConverter().toCoin(entry));
    }
}
