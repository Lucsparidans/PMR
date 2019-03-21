package com.example.hcipartbprototype;

import com.example.hcipartbprototype.Fragments.Screens.AppointmentsFragment;

import java.text.ParseException;
import java.util.Date;

public class LogEntry {
    private static final String TAG = "LogEntry";
    private static int idCounter = 0;

    private int id;
    private String date;
    private String title;
    private String Content;
    private Date dateObj;

    public LogEntry(String date, String title, String content) {
        this.id = idCounter++;
        this.date = date;
        this.title = title;
        Content = content;
        try {
            dateObj = AppointmentsFragment.INPUT_FORMAT.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    public LogEntry(Date date, String title, String content) {
        this.id = idCounter++;
        this.dateObj = date;
        this.title = title;
        Content = content;
        this.date = AppointmentsFragment.OUTPUT_FORMAT.format(date);
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return Content;
    }

    public Date getDateObj() {
        return dateObj;
    }
}
