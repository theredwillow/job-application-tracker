package com.jared;

import java.util.Date;

public class JobApplication {
    private Date dateApplied;
    private String company;
    private String url;
    private String status;

    public JobApplication(String c, String u, String s) {
        this.dateApplied = new Date();
        this.company = c;
        this.url = u;
        this.status = s;
    }

    public String toString() {
        return "Job Application [" +
                "date=" + dateApplied +
                ", company=" + company +
                ", url=" + url +
                ", status=" + status +
                "]";
    }
}
