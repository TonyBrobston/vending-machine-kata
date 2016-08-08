package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Product;
import com.vendingmachine.utils.Output;
import com.vendingmachine.utils.Validator;

import java.math.BigDecimal;

import static com.vendingmachine.utils.Output.*;

public class VendingMachineService {
    private BigDecimal runningTotal = BigDecimal.ZERO;

    public void initialStartUp() {
        displayWelcome();
        displayCoinAndProductOptions();
        askForNextCoin();
    }

    public void input(String value) {
        if (Validator.isACoin(value)) {
            inputCoin(new Coin(value));
        } else if (Validator.isAProduct(value)) {
            inputProductAndDispense(new Product(value));
        } else if (Validator.isReturn(value)) {
            returnCoins();
        } else {
            displayNotAValidInput();
            if (Validator.isGreaterThanZero(runningTotal)) {
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
        if (Validator.isGreaterThanZero(runningTotal)) {
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
