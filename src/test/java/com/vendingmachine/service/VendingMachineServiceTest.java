package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.domain.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.vendingmachine.constants.Coins.*;
import static com.vendingmachine.constants.Products.*;
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
        new VendingMachineService().initialStartUp();

        assertEquals("Welcome to this super awesome Vending Machine application\nCoin options: NICKEL, DIME, QUARTER. Product options: COLA, CHIPS, CANDY.\nInsert coin or select a product: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveToConsole() {
        Coin nickel = new Coin().setValue(NICKEL);

        new VendingMachineService().insertCoin(nickel);

        assertEquals("Current amount: $0.05\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveCurrentAmountTenCurrentAmountThirtyFive() {
        Coin nickel = new Coin().setValue(NICKEL);
        Coin quarter = new Coin().setValue(QUARTER);

        VendingMachineService vendingMachineService = new VendingMachineService();
        vendingMachineService.insertCoin(nickel);
        vendingMachineService.insertCoin(nickel);
        vendingMachineService.insertCoin(quarter);

        assertEquals("Current amount: $0.05\n" +
                "Current amount: $0.10\n" +
                "Current amount: $0.35\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveCoinReturnOne() {
        Coin nickel = new Coin().setValue(NICKEL);
        Coin penny = new Coin().setValue(PENNY);

        VendingMachineService vendingMachineService = new VendingMachineService();
        vendingMachineService.insertCoin(nickel);
        vendingMachineService.insertCoin(penny);

        assertEquals("Current amount: $0.05\n" +
                "Coin return: $0.01\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountTwentyFive() {
        Coin quarter = new Coin().setValue(QUARTER);

        new VendingMachineService().insertCoin(quarter);

        assertEquals("Current amount: $0.25\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCoinReturnOne() {
        Coin penny = new Coin().setValue(PENNY);

        new VendingMachineService().insertCoin(penny);

        assertEquals("Coin return: $0.01\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCoinReturnFifty() {
        Coin halfDollar = new Coin().setValue(HALF_DOLLAR);

        new VendingMachineService().insertCoin(halfDollar);

        assertEquals("Coin return: $0.50\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldTakeThreeQuartersAndDispenseChips() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        Coin quarter = new Coin().setValue(QUARTER);
        vendingMachineService.insertCoin(quarter);
        vendingMachineService.insertCoin(quarter);
        vendingMachineService.insertCoin(quarter);
        Product chips = new Product().setValue(CHIPS);

        vendingMachineService.dispenseProduct(chips);

        assertEquals("Current amount: $0.25\n" +
                "Current amount: $0.50\n" +
                "Current amount: $0.75\n" +
                "Product dispensed, thank you\nCurrent amount: $0.00\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldTakeOneQuartersAndAttemptToDispenseChips() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        Coin quarter = new Coin().setValue(QUARTER);
        vendingMachineService.insertCoin(quarter);
        Product chips = new Product().setValue(CHIPS);

        vendingMachineService.dispenseProduct(chips);

        assertEquals("Current amount: $0.25\n" +
                "Not enough money, price is $0.50\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldWorkWithStringsToTakeThreeQuartersAndDispenseChips() {
        VendingMachineService vendingMachineService = new VendingMachineService();
        vendingMachineService.input("quarter");
        vendingMachineService.input("quarter");
        vendingMachineService.input("quarter");

        vendingMachineService.input("chips");

        assertEquals("Current amount: $0.25\nInsert coin or select a product: " +
                "Current amount: $0.50\nInsert coin or select a product: " +
                "Current amount: $0.75\nInsert coin or select a product: " +
                "Product dispensed, thank you\nCurrent amount: $0.00\nInsert coin or select a product: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldHandleNeitherACoinNorAProductEvenKnowThatIsSupposedToBeImpossible() {
        VendingMachineService vendingMachineService = new VendingMachineService();

        vendingMachineService.input("potato cannon");

        assertEquals("Not a valid entry\nInsert coin or select a product: ", byteArrayOutputStream.toString());
    }

}
