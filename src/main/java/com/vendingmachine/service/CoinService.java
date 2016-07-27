package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;

public class CoinService {
    private Integer runningTotal = 0;

    public void insertCoin(Coin coin) {
        System.out.println(determineConsoleOutput(coin));
    }

    public CoinService() {
        System.out.println("Insert coin");
    }

    private String determineConsoleOutput(Coin coin) {
        Integer coinValue = coin.getValue();
        if (coin.isValid()) {
            runningTotal += coinValue;
            return "Current amount: " + runningTotal;
        } else {
            return "Coin return: " + coinValue;
        }
    }
}