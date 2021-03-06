package com.vendingmachine.constants;

import java.math.BigDecimal;

public final class Coins {
    public static final BigDecimal NONE = BigDecimal.ZERO;
    public static final BigDecimal PENNY = new BigDecimal(0.01);
    public static final BigDecimal NICKEL = new BigDecimal(0.05);
    public static final BigDecimal DIME = new BigDecimal(0.10);
    public static final BigDecimal QUARTER = new BigDecimal(0.25);

    private Coins() {}
}
