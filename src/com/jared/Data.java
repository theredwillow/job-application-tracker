package com.jared;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        getJobApplications();
    }

    public void loadFileData(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            // TODO Account for strings with commas in them
            while ( (line = reader.readLine()) != null )
                JobApplications.add(new JobApplication( line.split(",") ));
            reader.close();

            getJobApplications();
        }
        catch (FileNotFoundException e){
            System.out.println("That file couldn't be found. Sorry.");
        }
        catch (IOException e){
            System.out.println("There was an IOException, while trying to read file: " + e + ". Sorry.");
        }
    }

    public static void saveFileData(String filename) {
        try {
            FileWriter csvWriter = new FileWriter(filename);

            for (JobApplication jobApp : JobApplications) {
                csvWriter.append(String.join(",", jobApp.toString()));
                csvWriter.append("\n");
            }

            csvWriter.flush();
            csvWriter.close();

            System.out.println("Saved to file!");
            System.out.println();
        }
        catch (FileNotFoundException e){
            System.out.println("That file couldn't be found. Sorry.");
        }
        catch(IOException e) {
            System.out.println("There was an IOException, while trying to save to the file: " + e + ". Sorry.");
        }
    }

    public List<JobApplication> getJobApplications() {
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

        JobApplications.add(new JobApplication(
                newCompany,
                newUrl,
                "APPLIED"
        ));

        System.out.println("Done.");
        System.out.println();

        getJobApplications();

        // TODO Implement a save on-command functionality
        saveFileData("data.csv");
    }

}
