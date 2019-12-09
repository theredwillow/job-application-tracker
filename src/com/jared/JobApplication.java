package com.jared;

import java.util.Date;

public class JobApplication {
    private Date dateApplied;
    private String company;
    private String url;
    private StatusType status;

    private enum StatusType {
        APPLIED, REJECTED
    }

    public JobApplication(String company, String url, String status) {
        this.dateApplied = new Date();
        this.company = company;
        this.url = url;
        this.status = StatusType.APPLIED;
    }

    public String toString() {
        return "Job Application [" +
                "date=" + dateApplied +
                ", company=" + company +
                ", url=" + url +
                ", status=" + status.toString() +
                "]";
    }
}
