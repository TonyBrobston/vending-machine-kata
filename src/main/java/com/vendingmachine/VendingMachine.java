package com.vendingmachine;

import com.vendingmachine.domain.Coin;
import com.vendingmachine.service.VendingMachineService;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachineService vendingMachineService = new VendingMachineService();
        boolean continueLoop = true;
        do {
            String entry = scanner.next();
            if (!endLoop(entry)) {
                vendingMachineService.insertCoin(new Coin().setValue(entry));
            } else {
                continueLoop = false;
            }
        } while (continueLoop);
    }

    private static boolean endLoop(String entry) {
        return "end".equals(entry);
    }
}
