package com.jared;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobApplication {
    private Date dateApplied = new Date();
    private String company = "(NO COMPANY PROVIDED)";
    private String url = "(NO URL PROVIDED)";
    private StatusType status = StatusType.APPLIED;

    private enum StatusType {
        APPLIED, REJECTED
    }

    private static boolean isURL(String inURL) {
        return inURL.matches("^http[^ ]*");
    }

    private static Date validDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(inDate.trim());
        }
        catch(ParseException e) {
            return new Date();
        }
    }

    private static boolean isValidDate(String inDate) {
        List<SimpleDateFormat> knownPatterns = new ArrayList<>();
        knownPatterns.add(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy"));
        knownPatterns.add(new SimpleDateFormat("MM/dd/yy"));
        knownPatterns.add(new SimpleDateFormat("MM/dd/yyyy"));
        knownPatterns.add(new SimpleDateFormat("MMM dd yyyy"));

        for (SimpleDateFormat pattern : knownPatterns) {
            try {
                pattern.setLenient(false);
                pattern.parse(inDate.trim());
                return true;
            } catch (ParseException pe) {
                // FIXME Replace this with something cleaner, that doesn't throw linting warnings
                continue;
            }
        }
        return false;
    }

    private static boolean isStatus(String inStatus) {
        // FIXME Logic coded twice, should check against the enum
        return inStatus.equals("APPLIED") || inStatus.equals("REJECTED");
    }

    public JobApplication(String ...args) {
        for (String arg : args) {
            if ( isURL(arg) )
                this.url = arg;
            else if ( isStatus(arg) )
                this.status = StatusType.valueOf(arg);
            else if ( isValidDate(arg) )
                this.dateApplied = validDate(arg);
            else
                this.company = arg;
        }
    }

    public String toString() {
        return String.join( ",", dateApplied.toString(), company, url, status.toString() );
    }
}
