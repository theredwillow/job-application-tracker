package com.jared;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Data data = new Data();

    public static void main(String[] args) {
        System.out.println("Program starting...");
        data.loadMockData();
        data.getValue();
	    run();
    }

    /** Used to run the main operation over and over */
    public static void run() {
        System.out.println();
        System.out.println("What would you like to do? (i.e. add, print, end?)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        String[] responseParts = response.split(" ");

        String command = responseParts[0];
        String[] args = Arrays.copyOfRange(responseParts, 1, responseParts.length);

        switch (command) {
            case "add":
                data.addToValue(); // args
                break;
            case "print":
                data.getValue();
                break;
            case "end" :
                System.out.println("Oh okay, goodbye!");
                break;
            default:
                System.out.println("I'm sorry. What was that?");
                help();
        }

        if ( !command.equals("end") ) {
            run();
        }
    }

    public static void help() {
        System.out.println("You can say things like 'add' or 'print'.");
        System.out.println("Or, if you want to end the program, type 'end'.");
    }

}
