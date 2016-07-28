package com.vendingmachine.utility;

import static com.vendingmachine.constants.Coins.*;

public class Converter {
    public Integer toCoin(String entry) {
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
            return NULL;
        }
    }

    private boolean isPenny(String entry) {
        return "penny".equalsIgnoreCase(entry) || "1".equals(entry) || "one".equalsIgnoreCase(entry);
    }

    private boolean isNickel(String entry) {
        return "nickel".equalsIgnoreCase(entry) || "5".equals(entry) || "five".equalsIgnoreCase(entry);
    }

    private boolean isDime(String entry) {
        return "dime".equalsIgnoreCase(entry) || "10".equals(entry) || "ten".equalsIgnoreCase(entry);
    }

    private boolean isQuarter(String entry) {
        return "quarter".equalsIgnoreCase(entry) || "25".equals(entry) || "twentyfive".equalsIgnoreCase(entry);
    }

    private boolean isHalfDollar(String entry) {
        return "halfdollar".equalsIgnoreCase(entry) || "50".equals(entry) || "fifty".equalsIgnoreCase(entry);
    }

    private String removeSpaces(String entry) {
        return entry.replaceAll("\\s","");
    }
}
