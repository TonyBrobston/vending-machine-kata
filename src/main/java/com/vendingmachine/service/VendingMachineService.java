package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Product;
import com.vendingmachine.output.Output;
import com.vendingmachine.validator.Validator;

import java.math.BigDecimal;

public class VendingMachineService extends Output {
    private BigDecimal runningTotal = BigDecimal.ZERO;

    public void input(String value) {
        if (new Validator().isACoin(value)) {
            insertCoin(new Coin().setValue(value));
        } else if (new Validator().isAProduct(value)) {
            dispenseProduct(new Product().setValue(value));
        } else {
            displayNotAValidEntry();
        }
        askForNextCoin();
    }

    public void insertCoin(Coin coin) {
        addCoinToRunningTotal(coin);
    }

    public void dispenseProduct(Product product) {
        boolean hasEnoughCoinForProduct = (runningTotal.compareTo(product.getValue())) >= 0;
        if (hasEnoughCoinForProduct) {
            displayProductDispensed();
            runningTotal = BigDecimal.ZERO;
            displayRunningTotal(runningTotal);
        } else {
            displayNotEnoughMoney(product);
        }
    }

    public void initialStartUp() {
        displayWelcome();
        displayCoinAndProductOptions();
        askForNextCoin();
    }

    private void addCoinToRunningTotal(Coin coin) {
        if (coin.isValidForUse()) {
            runningTotal = runningTotal.add(coin.getValue());
            displayRunningTotal(runningTotal);
        } else {
            displayCoinReturn(coin);
        }
    }

}
