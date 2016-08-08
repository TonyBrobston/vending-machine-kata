package com.vendingmachine.domain;


import com.vendingmachine.utils.converter.CoinConverter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.vendingmachine.constants.Coins.*;

public class Coin {
    private final BigDecimal value;

    public Coin(final BigDecimal value) {
        this.value = value;
    }

    public Coin(final String value) {
        this.value = CoinConverter.toCoin(value);
    }

    public boolean isValidForUse() {
        List<BigDecimal> validCoins = Arrays.asList(NICKEL, DIME, QUARTER);
        return validCoins.contains(this.value);
    }

    public BigDecimal getValue() {
        return value;
    }
}
