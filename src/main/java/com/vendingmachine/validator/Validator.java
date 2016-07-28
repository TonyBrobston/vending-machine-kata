package com.vendingmachine.validator;

import com.vendingmachine.converter.CoinConverter;
import com.vendingmachine.converter.ProductConverter;

import java.math.BigDecimal;

import static com.vendingmachine.constants.Coins.NONE;
import static com.vendingmachine.constants.Products.INVALID;

public class Validator {
    public boolean isACoin(String value) {
        BigDecimal coin = new CoinConverter().toCoin(value);
        return !coin.equals(NONE);
    }

    public boolean isAProduct(String value) {
        BigDecimal product = new ProductConverter().toProduct(value);
        return !product.equals(INVALID);
    }
}
