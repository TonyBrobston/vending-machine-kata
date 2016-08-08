package com.vendingmachine.domain;


import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.vendingmachine.constants.Coins.*;
import static com.vendingmachine.utils.converter.CoinConverter.toCoin;

public class Coin {
    private final BigDecimal value;

    public Coin(final BigDecimal value) {
        this.value = value;
    }

    public Coin(final String value) {
        this.value = toCoin(value);
    }

    public boolean isValidForUse() {
        List<BigDecimal> validCoins = Arrays.asList(NICKEL, DIME, QUARTER);
        return validCoins.contains(this.value);
    }

    public BigDecimal getValue() {
        return value;
    }
}
