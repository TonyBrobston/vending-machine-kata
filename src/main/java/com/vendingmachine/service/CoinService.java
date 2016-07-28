package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;

public class CoinService {
    private Integer runningTotal = 0;

    public CoinService() {
        askForNextCoin();
    }

    public void insertCoin(Coin coin) {
        String consoleOutput = determineConsoleOutput(coin);
        System.out.println(consoleOutput);
        askForNextCoin();
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

    private void askForNextCoin() {
        System.out.print("Insert coin: ");
    }
}
