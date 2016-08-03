package com.vendingmachine;

import com.vendingmachine.service.VendingMachineService;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachineService vendingMachineService = new VendingMachineService();
        boolean continueLoop = true;
        startVendingMachineService(scanner, vendingMachineService, continueLoop);
    }

    private static void startVendingMachineService(Scanner scanner, VendingMachineService vendingMachineService, boolean continueLoop) {
        vendingMachineService.initialStartUp();
        do {
            String value = scanner.next();
            if ("end".equalsIgnoreCase(value)) {
                continueLoop = false;
            } else {
                vendingMachineService.input(value);
            }
        } while (continueLoop);
    }
}
