package com.jared;

import java.util.Date;

public class JobApplication {
    private Date dateApplied = new Date();
    private String company;
    private String url;
    private StatusType status;

    private enum StatusType {
        APPLIED, REJECTED
    }

    public JobApplication(String company, String url, String status) {
        this.company = company;
        this.url = url;
        this.status = StatusType.valueOf(status);
    }

    public String toString() {
        return String.join( ",", dateApplied.toString(), company, url, status.toString() );
    }
}
