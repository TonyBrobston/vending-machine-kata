package service;

import domain.Coin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void shouldPrintCurrentAmountFiveToConsole() {
        Coin nickel = new Coin().setValue(5);

        new CoinService().insertCoin(nickel);

        assertEquals("Current amount: 5\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveCurrentAmountTenCurrentAmountThirtyFive() {
        Coin nickel = new Coin().setValue(5);
        Coin quarter = new Coin().setValue(25);

        CoinService coinService = new CoinService();
        coinService.insertCoin(nickel);
        coinService.insertCoin(nickel);
        coinService.insertCoin(quarter);

        assertEquals("Current amount: 5\nCurrent amount: 10\nCurrent amount: 35\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountFiveCoinReturnOne() {
        Coin nickel = new Coin().setValue(5);
        Coin penny = new Coin().setValue(1);

        CoinService coinService = new CoinService();
        coinService.insertCoin(nickel);
        coinService.insertCoin(penny);

        assertEquals("Current amount: 5\nCoin return: 1\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCurrentAmountTwentyFive() {
        Coin quarter = new Coin().setValue(25);

        new CoinService().insertCoin(quarter);

        assertEquals("Current amount: 25\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCoinReturnOne() {
        Coin penny = new Coin().setValue(1);

        new CoinService().insertCoin(penny);

        assertEquals("Coin return: 1\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldPrintCoinReturnFifty() {
        Coin halfDollar = new Coin().setValue(50);

        new CoinService().insertCoin(halfDollar);

        assertEquals("Coin return: 50\n", byteArrayOutputStream.toString());
    }
}
