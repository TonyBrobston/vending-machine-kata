package service;

import domain.Coin;

public class CoinService {
    public void CoinService() {
        System.out.println("Insert coin");
    }

    private Integer runningTotal = 0;

    public void insertCoin(Coin coin) {
        System.out.println(determineConsoleOutput(coin));
    }

    private String determineConsoleOutput(Coin coin) {
        if (coin.isValid()) {
            runningTotal += coin.getValue();
            return "Current amount: " + runningTotal;
        } else if (coin.getValue() == null) {
            return "Insert coin";
        } else {
            return "Coin return: " + coin.getValue();
        }
    }
}
