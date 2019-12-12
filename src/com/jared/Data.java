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
            Scanner scanner;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                String company = "(NO COMPANY PROVIDED)";
                String url = "(NO URL PROVIDED)";
                String status = "APPLIED";
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    // TODO Swap indexes with regex identifiers
                    if (index == 0)
                        company = data;
                    else if (index == 1)
                        url = data;
                    else if (index == 2)
                        status = data;
                    else
                        System.out.println("invalid data::" + data);
                    index++;
                }
                index = 0;
                JobApplications.add(new JobApplication(company, url, status));
            }

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

        JobApplication newApplication = new JobApplication(
                newCompany,
                newUrl,
                "APPLIED"
        );
        JobApplications.add(newApplication);

        System.out.println("Done.");
        System.out.println();

        getJobApplications();

        // TODO Implement a save on-command functionality
        saveFileData("data.csv");
    }

}
