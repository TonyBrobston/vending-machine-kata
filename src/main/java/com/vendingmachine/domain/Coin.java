package com.vendingmachine.domain;

import com.vendingmachine.converter.CoinConverter;

import java.util.Arrays;
import java.util.List;

import static com.vendingmachine.constants.Coins.*;

public class Coin {
    private Integer value = 0;

    public boolean isValid() {
        List<Integer> validCoins = Arrays.asList(NICKEL, DIME, QUARTER);
        return validCoins.contains(this.value);
    }

    public Coin setValue(String value) {
        this.value = new CoinConverter().toCoin(value);
        return this;
    }

    public Integer getValue() {
        return value;
    }

    public Coin setValue(Integer value) {
        this.value = value;
        return this;
    }
}
