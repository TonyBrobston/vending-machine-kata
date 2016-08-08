package com.vendingmachine.utils.converter;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static com.vendingmachine.constants.Products.*;
import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class ProductConverterTest {
    @DataProvider
    public static Object[][] toProductDataProvier() {
        return new Object[][] {
                { "cola", COLA },
                { "Cola", COLA },
                { "Chips", CHIPS },
                { "chips", CHIPS },
                { "candy", CANDY },
                { "Candy", CANDY },
                { "", INVALID},
                { "asdf", INVALID},
                { null, INVALID}
        };
    }

    @Test
    @UseDataProvider("toProductDataProvier")
    public void shouldConvertStringToBigDecimal(String entry, BigDecimal expected) {
        assertEquals(expected, ProductConverter.toProduct(entry));
    }
}
