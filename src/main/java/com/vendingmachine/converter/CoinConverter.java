package com.vendingmachine.converter;

import java.math.BigDecimal;

import static com.vendingmachine.constants.Coins.*;

public class CoinConverter {
    public BigDecimal toCoin(String entry) {
        String entryWithoutSpaces = removeSpaces(entry);
        if (isPenny(entryWithoutSpaces)) {
            return PENNY;
        } else if (isNickel(entryWithoutSpaces)) {
            return NICKEL;
        } else if (isDime(entryWithoutSpaces)) {
            return DIME;
        } else if (isQuarter(entryWithoutSpaces)) {
            return QUARTER;
        } else if (isHalfDollar(entryWithoutSpaces)) {
            return HALF_DOLLAR;
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

    private boolean isHalfDollar(String entry) {
        return "halfdollar".equalsIgnoreCase(entry) || ".50".equals(entry) || "0.50".equals(entry) || ".5".equals(entry) || "0.5".equals(entry);
    }

    private String removeSpaces(String entry) {
        return entry.replaceAll("\\s","");
    }
}
