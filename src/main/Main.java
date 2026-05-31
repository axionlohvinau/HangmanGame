package main;

import logic.Processor;
import util.StringVariables;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldExit  = false;
        Processor processor = new Processor();
        while (!shouldExit ) {
            boolean isValidInput = false;
            System.out.println(StringVariables.MENU_PROMPT);
            while (!isValidInput) {
                String startOrExitString = scanner.nextLine();
                if (startOrExitString.equalsIgnoreCase(StringVariables.MENU_YES)) {
                    processor.run();
                    isValidInput = true;
                } else if (startOrExitString.equalsIgnoreCase(StringVariables.MENU_NO)) {
                    shouldExit  = true;
                    isValidInput = true;
                } else {
                    System.out.println(StringVariables.MENU_INVALID);
                }
            }
        }
        scanner.close();
    }
}
