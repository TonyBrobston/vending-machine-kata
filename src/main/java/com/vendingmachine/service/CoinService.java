package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class CoinService {
    private BigDecimal runningTotal = BigDecimal.ZERO;

    public CoinService() {
        askForNextCoin();
    }

    public void insertCoin(Coin coin) {
        String consoleOutput = determineConsoleOutput(coin);
        System.out.println(consoleOutput);
        askForNextCoin();
    }

    private String determineConsoleOutput(Coin coin) {
        BigDecimal coinValue = coin.getValue();
        if (coin.isValid()) {
            runningTotal = runningTotal.add(coinValue);
            return "Current amount: " + formatCurrency(runningTotal);
        } else {
            return "Coin return: " + formatCurrency(coinValue);
        }
    }

    private String formatCurrency(BigDecimal runningTotal) {
        return NumberFormat.getCurrencyInstance().format(runningTotal);
    }

    private void askForNextCoin() {
        System.out.print("Insert coin: ");
    }
}
