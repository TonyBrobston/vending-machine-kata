package com.vendingmachine.output;

import com.vendingmachine.domain.Product;

import java.math.BigDecimal;
import java.text.NumberFormat;

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

    protected void displayRunningTotal(BigDecimal runningTotal) {
        System.out.println("Current amount: " + formatCurrency(runningTotal));
    }

    protected void displayProductDispensed() {
        System.out.println("Product dispensed, thank you");
    }

    protected void displayNotEnoughMoney(Product product) {
        System.out.println("Not enough money, price is " + formatCurrency(product.getValue()));
    }

    protected void displayCoinReturn(BigDecimal value) {
        System.out.println("Coin return: " + formatCurrency(value));
    }

    protected void displayNotAValidInput() {
        System.out.println("Not a valid input");
    }

    protected String formatCurrency(BigDecimal runningTotal) {
        return NumberFormat.getCurrencyInstance().format(runningTotal);
    }
}
