package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Product;
import com.vendingmachine.utils.Output;
import com.vendingmachine.utils.Validator;

import java.math.BigDecimal;

public class VendingMachineService extends Output {
    private BigDecimal runningTotal = BigDecimal.ZERO;

    public void initialStartUp() {
        displayWelcome();
        displayCoinAndProductOptions();
        askForNextCoin();
    }

    public void input(String value) {
        if (new Validator().isACoin(value)) {
            inputCoin(new Coin().setValue(value));
        } else if (new Validator().isAProduct(value)) {
            inputProductAndDispense(new Product().setValue(value));
        } else if (new Validator().isReturn(value)) {
            returnCoins();
        } else {
            displayNotAValidInput();
            if (new Validator().isGreaterThanZero(runningTotal)) {
                displayCurrentAmount(runningTotal);
            }
        }
        askForNextCoin();
    }

    public void inputCoin(Coin coin) {
        if (coin.isValidForUse()) {
            runningTotal = runningTotal.add(coin.getValue());
            displayCurrentAmount(runningTotal);
        } else {
            displayCoinReturn(coin.getValue());
        }
    }

    public void inputProductAndDispense(Product product) {
        if (product.isEnoughCoin(runningTotal)) {
            dispenseProduct(product);
        } else {
            displayNotEnoughMoney(product);
        }
    }

    private void dispenseProduct(Product product) {
        displayProductDispensed();
        runningTotal = runningTotal.subtract(product.getValue());
        if (new Validator().isGreaterThanZero(runningTotal)) {
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
