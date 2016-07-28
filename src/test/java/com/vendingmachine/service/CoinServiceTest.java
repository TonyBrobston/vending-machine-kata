package com.vendingmachine.service;

import com.vendingmachine.domain.Coin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static com.vendingmachine.constants.Coins.*;
import static org.junit.Assert.assertEquals;

public class CoinServiceTest {
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
    public void shouldPrintInsertCoinIfNoCoinIsInserted() {
        new CoinService();

        assertEquals("Insert coin or select a product: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveToConsole() {
        Coin nickel = new Coin().setValue(NICKEL);

        new CoinService().insertCoin(nickel);

        assertEquals("Insert coin or select a product: Current amount: $0.05\nInsert coin or select a product: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveCurrentAmountTenCurrentAmountThirtyFive() {
        Coin nickel = new Coin().setValue(NICKEL);
        Coin quarter = new Coin().setValue(QUARTER);

        CoinService coinService = new CoinService();
        coinService.insertCoin(nickel);
        coinService.insertCoin(nickel);
        coinService.insertCoin(quarter);

        assertEquals("Insert coin or select a product: Current amount: $0.05\nInsert coin or select a product: Current amount: $0.10\nInsert coin or select a product: Current amount: $0.35\nInsert coin or select a product: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveCoinReturnOne() {
        Coin nickel = new Coin().setValue(NICKEL);
        Coin penny = new Coin().setValue(PENNY);

        CoinService coinService = new CoinService();
        coinService.insertCoin(nickel);
        coinService.insertCoin(penny);

        assertEquals("Insert coin or select a product: Current amount: $0.05\nInsert coin or select a product: Coin return: $0.01\nInsert coin or select a product: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountTwentyFive() {
        Coin quarter = new Coin().setValue(QUARTER);

        new CoinService().insertCoin(quarter);

        assertEquals("Insert coin or select a product: Current amount: $0.25\nInsert coin or select a product: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCoinReturnOne() {
        Coin penny = new Coin().setValue(PENNY);

        new CoinService().insertCoin(penny);

        assertEquals("Insert coin or select a product: Coin return: $0.01\nInsert coin or select a product: ", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCoinReturnFifty() {
        Coin halfDollar = new Coin().setValue(HALF_DOLLAR);

        new CoinService().insertCoin(halfDollar);

        assertEquals("Insert coin or select a product: Coin return: $0.50\nInsert coin or select a product: ", byteArrayOutputStream.toString());
    }
}
