package com.vendingmachine.utils;

import com.vendingmachine.domain.Product;

import java.math.BigDecimal;

public class Output {
    protected void displayWelcome() {
        System.out.println("Welcome to this super awesome Vending Machine application");
    }

    protected void displayCoinAndProductOptions() {
        System.out.println("Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.");
    }

    protected void askForNextCoin() {
        System.out.print("Insert coin, select a product, or return: ");
    }

    protected void displayCurrentAmount(BigDecimal runningTotal) {
        System.out.println("Current amount: " + Formatter.toCurrency(runningTotal));
    }

    protected void displayProductDispensed() {
        System.out.println("Product dispensed, thank you");
    }

    protected void displayNotEnoughMoney(Product product) {
        System.out.println("Not enough money, price is " + Formatter.toCurrency(product.getValue()));
    }

    protected void displayCoinReturn(BigDecimal value) {
        System.out.println("Coin return: " + Formatter.toCurrency(value));
    }

    protected void displayNotAValidInput() {
        System.out.println("Not a valid input or sold out.");
    }

}
