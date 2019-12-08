package com.jared;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Data data = new Data();

    public static void main(String[] args) {
        System.out.println("Program starting...");
        data.getValue();
	    run();
    }

    public static void run() {
        System.out.println();
        System.out.println("What would you like to do? (i.e. add, remove, update, end?)");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        String[] responseParts = response.split(" ");

        String command = responseParts[0];
        String[] args = Arrays.copyOfRange(responseParts, 1, responseParts.length);

        if( command.equals("add") ) {
            data.addToValue(args);
        }
        else if ( command.equals("end") ) {
            System.out.println("Oh okay, goodbye!");
            return;
        }
        else {
            System.out.println("I'm sorry. What?");
            help();
        }
        run();
    }

    public static void help() {
        System.out.println("You can say things like 'add' or 'update'.");
        System.out.println("Or, if you want to end the program, type 'end'.");
    }

}
