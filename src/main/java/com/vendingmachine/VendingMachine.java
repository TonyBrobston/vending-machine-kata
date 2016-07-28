package com.vendingmachine;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.service.CoinService;
import com.vendingmachine.utility.Converter;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoinService coinService = new CoinService();

        boolean continueLoop = true;
        do {
            String entry = scanner.next();
            if (endLoop(entry)) {
                continueLoop = false;
            } else {
                coinService.insertCoin(new Coin().setValue(entry));
            }
        } while (continueLoop);
    }

    private static boolean endLoop(String entry) {
        return "end".equals(entry);
    }
}
