package com.vendingmachine.converter;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

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
                { "1", PENNY },
                { "5", NICKEL },
                { "10", DIME },
                { "25", QUARTER },
                { "50", HALF_DOLLAR },
                { "one", PENNY },
                { "five", NICKEL },
                { "ten", DIME },
                { "twentyfive", QUARTER },
                { "fifty", HALF_DOLLAR },
                { "", NULL },
                { "asdf", NULL }
        };
    }

    @Test
    @UseDataProvider("toCoinDataProvier")
    public void shouldConvertStringToInteger(String entry, Integer expected) {
        assertEquals(expected, new CoinConverter().toCoin(entry));
    }
}
