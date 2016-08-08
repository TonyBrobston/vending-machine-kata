package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Product;

import java.math.BigDecimal;

import static com.vendingmachine.utils.Output.*;
import static com.vendingmachine.utils.Validator.*;

public class VendingMachineService {
    private BigDecimal runningTotal = BigDecimal.ZERO;

    public void initialStartUp() {
        displayWelcome();
        displayCoinAndProductOptions();
        askForNextCoin();
    }

    public void input(String value) {
        if (isACoin(value)) {
            inputCoin(new Coin(value));
        } else if (isAProduct(value)) {
            inputProductAndDispense(new Product(value));
        } else if (isReturn(value)) {
            returnCoins();
        } else {
            displayNotAValidInput();
            if (isGreaterThanZero(runningTotal)) {
                displayCurrentAmount(runningTotal);
            }
        }
        askForNextCoin();
    }

    void inputCoin(Coin coin) {
        if (coin.isValidForUse()) {
            runningTotal = runningTotal.add(coin.getValue());
            displayCurrentAmount(runningTotal);
        } else {
            displayCoinReturn(coin.getValue());
        }
    }

    void inputProductAndDispense(Product product) {
        if (product.isEnoughCoin(runningTotal)) {
            dispenseProduct(product);
        } else {
            displayNotEnoughMoney(product);
        }
    }

    private void dispenseProduct(Product product) {
        displayProductDispensed();
        runningTotal = runningTotal.subtract(product.getValue());
        if (isGreaterThanZero(runningTotal)) {
            returnCoins();
        } else {
            displayCurrentAmount(runningTotal);
        }
    }

    private void returnCoins() {
        displayCoinReturn(runningTotal);
        runningTotal = BigDecimal.ZERO;
    }

}
