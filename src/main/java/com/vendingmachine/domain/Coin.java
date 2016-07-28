package com.vendingmachine.domain;

import com.vendingmachine.converter.CoinConverter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.vendingmachine.constants.Coins.*;

public class Coin {
    private BigDecimal value = BigDecimal.ZERO;

    public boolean isValid() {
        List<BigDecimal> validCoins = Arrays.asList(NICKEL, DIME, QUARTER);
        return validCoins.contains(this.value);
    }

    public Coin setValue(String value) {
        this.value = new CoinConverter().toCoin(value);
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Coin setValue(BigDecimal value) {
        this.value = value;
        return this;
    }
}
