package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.vendingmachine.constants.Coins.*;
import static com.vendingmachine.constants.Products.CHIPS;
import static org.junit.Assert.assertEquals;

public class VendingMachineServiceTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldPrintInsertCoinIfInitialStartup() {
        new VendingMachineService();

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveToConsole() {
        Coin nickel = new Coin(NICKEL);

        new VendingMachineService().inputCoin(nickel);

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.05\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveCurrentAmountTenCurrentAmountThirtyFive() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        Coin nickel = new Coin(NICKEL);
        Coin quarter = new Coin(QUARTER);

        vendingMachineService.inputCoin(nickel);
        vendingMachineService.inputCoin(nickel);
        vendingMachineService.inputCoin(quarter);

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.05\n" +
                "Current amount: $0.10\n" +
                "Current amount: $0.35\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveCoinReturnOne() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        Coin nickel = new Coin(NICKEL);
        Coin penny = new Coin(PENNY);

        vendingMachineService.inputCoin(nickel);
        vendingMachineService.inputCoin(penny);

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.05\n" +
                "Coin return: $0.01\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountTwentyFive() {
        Coin quarter = new Coin(QUARTER);

        new VendingMachineService().inputCoin(quarter);

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.25\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCoinReturnOne() {
        Coin penny = new Coin(PENNY);

        new VendingMachineService().inputCoin(penny);

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Coin return: $0.01\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldTakeTwoQuartersAndDispenseChips() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        Coin quarter = new Coin(QUARTER);
        vendingMachineService.inputCoin(quarter);
        vendingMachineService.inputCoin(quarter);
        Product chips = new Product(CHIPS);

        vendingMachineService.inputProductAndDispense(chips);

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.25\n" +
                "Current amount: $0.50\n" +
                "Product dispensed, thank you\nCurrent amount: $0.00\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldTakeOneQuartersAndAttemptToDispenseChips() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        Coin quarter = new Coin(QUARTER);
        vendingMachineService.inputCoin(quarter);
        Product chips = new Product(CHIPS);

        vendingMachineService.inputProductAndDispense(chips);

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.25\n" +
                "Not enough money, price is $0.50\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldTakeThreeQuartersDispenseChipsAndPutOneQuarterInTheCoinReturn() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        vendingMachineService.input("quarter");
        vendingMachineService.input("quarter");
        vendingMachineService.input("quarter");

        vendingMachineService.input("chips");

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.25\nInsert coin, select a product, or return: " +
                "Current amount: $0.50\nInsert coin, select a product, or return: " +
                "Current amount: $0.75\nInsert coin, select a product, or return: " +
                "Product dispensed, thank you\nCoin return: $0.25\nInsert coin, select a product, or return: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldTakeThreeQuartersDispenseChipsPutOneQuarterInTheCoinReturnAndTakeOneQuarter() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        vendingMachineService.input("quarter");
        vendingMachineService.input("quarter");
        vendingMachineService.input("quarter");
        vendingMachineService.input("chips");

        vendingMachineService.input("quarter");

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.25\nInsert coin, select a product, or return: " +
                "Current amount: $0.50\nInsert coin, select a product, or return: " +
                "Current amount: $0.75\nInsert coin, select a product, or return: " +
                "Product dispensed, thank you\nCoin return: $0.25\nInsert coin, select a product, or return: " +
                "Current amount: $0.25\nInsert coin, select a product, or return: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldTakeThreeDimesAndReturnThem() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        vendingMachineService.input("dime");
        vendingMachineService.input("dime");
        vendingMachineService.input("dime");

        vendingMachineService.input("Return");

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.10\nInsert coin, select a product, or return: " +
                "Current amount: $0.20\nInsert coin, select a product, or return: " +
                "Current amount: $0.30\nInsert coin, select a product, or return: " +
                "Coin return: $0.30\nInsert coin, select a product, or return: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldTakeADimeAndAProductThatIsOutOfStockAndDisplaySoldOut() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        vendingMachineService.input("dime");

        vendingMachineService.input("peanuts");

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Current amount: $0.10\nInsert coin, select a product, or return: " +
                "Not a valid input or sold out.\nCurrent amount: $0.10\nInsert coin, select a product, or return: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldTakeAProductThatIsOutOfStockAndDisplaySoldOut() {
        VendingMachineService vendingMachineService = new VendingMachineService();

        vendingMachineService.input("peanuts");

        assertEquals("Welcome to this super awesome Vending Machine application\n" +
                "Coin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY. Other commands: RETURN, END.\n" +
                "Insert coin, select a product, or return: " +
                "Not a valid input or sold out.\nInsert coin, select a product, or return: ", byteArrayOutputStream.toString());
    }
}
