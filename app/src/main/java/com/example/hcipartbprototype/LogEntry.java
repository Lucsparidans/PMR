package com.example.hcipartbprototype;

public class LogEntry {
    private static final String TAG = "LogEntry";
    private static int idCounter = 0;

    private int id;
    private String date;
    private String title;
    private String Content;

    public LogEntry(String date, String title, String content) {
        this.id = idCounter++;
        this.date = date;
        this.title = title;
        Content = content;
    }
}
