package com.vendingmachine.utils;

import com.vendingmachine.domain.Product;

import java.math.BigDecimal;

import static com.vendingmachine.utils.Formatter.toCurrency;

public final class Output {
    public static void displayWelcome() {
        System.out.println("Welcome to this super awesome Vending Machine application");
    }

    public static void displayCoinAndProductOptions() {
        System.out.println("Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.");
    }

    public static void askForNextCoin() {
        System.out.print("Insert coin, select a product, or return: ");
    }

    public static void displayCurrentAmount(BigDecimal runningTotal) {
        System.out.println("Current amount: " + toCurrency(runningTotal));
    }

    public static void displayProductDispensed() {
        System.out.println("Product dispensed, thank you");
    }

    public static void displayNotEnoughMoney(Product product) {
        System.out.println("Not enough money, price is " + toCurrency(product.getValue()));
    }

    public static void displayCoinReturn(BigDecimal value) {
        System.out.println("Coin return: " + toCurrency(value));
    }

    public static void displayNotAValidInput() {
        System.out.println("Not a valid input or sold out.");
    }

}
