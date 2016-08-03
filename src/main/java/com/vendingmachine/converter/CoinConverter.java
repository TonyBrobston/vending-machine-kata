package com.vendingmachine.converter;

import java.math.BigDecimal;

import static com.vendingmachine.constants.Coins.*;

public class CoinConverter {
    public BigDecimal toCoin(String entry) {
        if (isPenny(entry)) {
            return PENNY;
        } else if (isNickel(entry)) {
            return NICKEL;
        } else if (isDime(entry)) {
            return DIME;
        } else if (isQuarter(entry)) {
            return QUARTER;
        } else {
            return NONE;
        }
    }

    private boolean isPenny(String entry) {
        return "penny".equalsIgnoreCase(entry) || ".01".equals(entry) || "0.01".equals(entry);
    }

    private boolean isNickel(String entry) {
        return "nickel".equalsIgnoreCase(entry) || ".05".equals(entry) || "0.05".equals(entry);
    }

    private boolean isDime(String entry) {
        return "dime".equalsIgnoreCase(entry) || ".10".equals(entry) || "0.10".equals(entry) || ".1".equals(entry) || "0.1".equals(entry);
    }

    private boolean isQuarter(String entry) {
        return "quarter".equalsIgnoreCase(entry) || ".25".equals(entry) || "0.25".equals(entry);
    }
}
