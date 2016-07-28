package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Product;
import com.vendingmachine.validator.Validator;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class VendingMachineService {
    private BigDecimal runningTotal = BigDecimal.ZERO;

    public VendingMachineService() {
        askForNextCoin();
    }

    public void input(String value) {
        if (new Validator().isACoin(value)) {
            insertCoin(new Coin().setValue(value));
        } else {
            dispenseProduct(new Product().setValue(value));
        }
    }

    public void insertCoin(Coin coin) {
        displayRunningTotalOrCoinReturn(coin);
        askForNextCoin();
    }

    public void dispenseProduct(Product product) {
        if ((runningTotal.compareTo(product.getValue())) >= 0) {
            displayProductDispensed();
            runningTotal = BigDecimal.ZERO;
            displayRunningTotal();
        } else {
            notEnoughMoney(product);
        }
        askForNextCoin();
    }

    private void displayRunningTotalOrCoinReturn(Coin coin) {
        if (coin.isValidForUse()) {
            runningTotal = runningTotal.add(coin.getValue());
            displayRunningTotal();
        } else {
            System.out.println("Coin return: " + formatCurrency(coin.getValue()));
        }
    }

    private void displayRunningTotal() {
        System.out.println("Current amount: " + formatCurrency(runningTotal));
    }

    private void askForNextCoin() {
        System.out.print("Insert coin or select a product: ");
    }

    private void displayProductDispensed() {
        System.out.println("Product dispensed, thank you");
    }

    private void notEnoughMoney(Product product) {
        System.out.println("Not enough money, price is " + formatCurrency(product.getValue()));
    }

    private String formatCurrency(BigDecimal runningTotal) {
        return NumberFormat.getCurrencyInstance().format(runningTotal);
    }
}
