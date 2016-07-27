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
        Integer coinValue = coin.getValue();
        if (coin.isValid()) {
            runningTotal += coinValue;
            return "Current amount: " + runningTotal;
        } else if (new Integer(0).equals(coinValue)) {
            return "Insert coin";
        } else {
            return "Coin return: " + coinValue;
        }
    }
}
