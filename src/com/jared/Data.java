package com.jared;

import java.util.*;

/** Used to connect with the database. */
public class Data {

    static ArrayList<JobApplication> value = new ArrayList<>();

    // TODO Connect to a real database
    public void loadMockData() {
        value.add(new JobApplication(
                "Walmart",
                "http://www.walmart.com/careers/this-is-a-fake-job.html",
                "APPLIED"
        ));
        value.add(new JobApplication(
                "Walgreen's",
                "https:///www.indeed.com/walgreens-job-1234.php",
                "REJECTED"
        ));
    }

    public ArrayList<JobApplication> getValue() {
        System.out.println();

        System.out.println("The value is currently...");
        for ( JobApplication job : value )
            System.out.println(job);
        if ( value.size() == 0 )
            System.out.println("EMPTY");

        System.out.println();

        return value;
    }

    public void addToValue() {
        getValue();

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the url of the new job posting?");
        String newUrl = scanner.nextLine();
        System.out.println();

        System.out.println("What is the name of the company?");
        String newCompany = scanner.nextLine();
        System.out.println();

        JobApplication newApplication = new JobApplication(
                newCompany,
                newUrl,
                "Applied"
        );
        value.add(newApplication);

        System.out.println("Done.");
        getValue();
    }

}
