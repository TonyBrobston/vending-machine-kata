package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Product;
import com.vendingmachine.validator.Validator;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class VendingMachineService {
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
        displayRunningTotalOrCoinReturn(coin);
    }

    public void dispenseProduct(Product product) {
        if ((runningTotal.compareTo(product.getValue())) >= 0) {
            displayProductDispensed();
            runningTotal = BigDecimal.ZERO;
            displayRunningTotal();
        } else {
            displayNotEnoughMoney(product);
        }
    }

    public void initialStartUp() {
        displayWelcome();
        displayCoinAndProductOptions();
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

    private void displayWelcome() {
        System.out.println("Welcome to this super awesome Vending Machine application");
    }

    private void displayCoinAndProductOptions() {
        System.out.println("Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY.");
    }

    private void displayRunningTotal() {
        System.out.println("Current amount: " + formatCurrency(runningTotal));
    }

    private void displayProductDispensed() {
        System.out.println("Product dispensed, thank you");
    }

    private void displayNotEnoughMoney(Product product) {
        System.out.println("Not enough money, price is " + formatCurrency(product.getValue()));
    }

    private void displayNotAValidEntry() {
        System.out.println("Not a valid entry");
    }

    private void askForNextCoin() {
        System.out.print("Insert coin or select a product: ");
    }

    private String formatCurrency(BigDecimal runningTotal) {
        return NumberFormat.getCurrencyInstance().format(runningTotal);
    }
}
