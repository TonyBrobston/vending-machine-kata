package com.vendingmachine.domain;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static com.vendingmachine.constants.Products.CANDY;
import static com.vendingmachine.constants.Products.CHIPS;
import static org.junit.Assert.assertEquals;

@RunWith(DataProviderRunner.class)
public class ProductTest {
    @DataProvider
    public static Object[][] productConverterDataProvider() {
        return new Object[][] {
                { "chips", CHIPS },
                { "Candy", CANDY }
        };
    }

    @Test
    @UseDataProvider("productConverterDataProvider")
    public void shouldConvertStringsToBigDecimalInSetter(String in, BigDecimal out) {
        assertEquals(out, new Product().setValue(in).getValue());
    }

    @DataProvider
    public static Object[][] isEnoughCoinDataProvider() {
        return new Object[][] {
                { new BigDecimal(0.75), CHIPS, true },
                { new BigDecimal(0.25), CHIPS, false },
                { null, CHIPS, false }
        };
    }

    @Test
    @UseDataProvider("isEnoughCoinDataProvider")
    public void shouldPassIfIsEnoughCoinForProduct(BigDecimal runningTotal, BigDecimal value, boolean expected) {
        Product product = new Product().setValue(value);

        boolean isEnoughForProduct = product.isEnoughCoin(runningTotal);

        assertEquals(expected, isEnoughForProduct);
    }


}