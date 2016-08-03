package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Product;
import com.vendingmachine.output.Output;
import com.vendingmachine.validator.Validator;

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
            displayCoinReturn(runningTotal);
            runningTotal = BigDecimal.ZERO;
        } else {
            displayNotAValidInput();
        }
        askForNextCoin();
    }

    public void inputCoin(Coin coin) {
        if (coin.isValidForUse()) {
            runningTotal = runningTotal.add(coin.getValue());
            displayRunningTotal(runningTotal);
        } else {
            displayCoinReturn(coin.getValue());
        }
    }

    public void inputProductAndDispense(Product product) {
        if (runningTotal.compareTo(product.getValue()) >= 0) {
            dispenseProduct(product);
        } else {
            displayNotEnoughMoney(product);
        }
    }

    private void dispenseProduct(Product product) {
        displayProductDispensed();
        runningTotal = runningTotal.subtract(product.getValue());
        if (runningTotal.compareTo(BigDecimal.ZERO) > 0) {
            displayCoinReturn(runningTotal);
            runningTotal = BigDecimal.ZERO;
        } else {
            displayRunningTotal(runningTotal);
        }
    }

}
