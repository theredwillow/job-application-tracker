package com.jared;

import java.util.*;

/** Used to connect with the database. */
public class Data {

    static List<JobApplication> JobApplications = new ArrayList<>();

    // TODO Connect to a real database
    public void loadMockData() {
        JobApplications.add(new JobApplication(
                "Walmart",
                "http://www.walmart.com/careers/this-is-a-fake-job.html",
                "APPLIED"
        ));
        JobApplications.add(new JobApplication(
                "Walgreen's",
                "https:///www.indeed.com/walgreens-job-1234.php",
                "REJECTED"
        ));
    }

    public List<JobApplication> getJobApplications() {
        System.out.println();

        System.out.println("Your job applications are currently...");
        for ( JobApplication job : JobApplications )
            System.out.println(job);
        if ( JobApplications.size() == 0 )
            System.out.println("EMPTY");

        System.out.println();

        return JobApplications;
    }

    public void addToJobApplications() {
        getJobApplications();

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
                "APPLIED"
        );
        JobApplications.add(newApplication);

        System.out.println("Done.");
        getJobApplications();
    }

}
