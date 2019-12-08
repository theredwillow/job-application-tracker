package com.jared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Data {

    private static final String[] mockData = {
            "Hey, I'm from the 'database'. Lol.",
            "I'm more data"
    };

    private ArrayList<String> value = new ArrayList<>(Arrays.asList(mockData));

    public ArrayList<String> getValue() {
        System.out.println();

        final String printableValue = Arrays.toString(value.toArray());
        System.out.println("The value is currently '" + printableValue + "'.");
        return value;
    }

    public void addToValue() {
        System.out.println();
        getValue();

        System.out.println("What do you want to add to it?");
        Scanner scanner = new Scanner(System.in);
        String newValue = scanner.nextLine();
        value.add(newValue);

        System.out.println("Done.");
        getValue();
    }

    public void addToValue(String[] newData) {
        if( newData.length == 0 ) {
            addToValue();
            return;
        }

        value.addAll( Arrays.asList(newData) );

        System.out.println("Done.");
        getValue();
    }

}
