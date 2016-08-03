package com.vendingmachine.enumerations;

import java.math.BigDecimal;

public enum CoinsEnum {
    PENNY(new BigDecimal(0.01));

    private BigDecimal coin;

    CoinsEnum(BigDecimal coin) {
        this.coin = coin;
    }

    public BigDecimal getCoin() {
        return coin;
    }
}
