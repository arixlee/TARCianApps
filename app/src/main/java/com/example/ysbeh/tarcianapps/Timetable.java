package com.example.ysbeh.tarcianapps;

import java.io.Serializable;

/**
 * Created by lee on 19/12/2016.
 */

public class Timetable implements Serializable {
    private String course;
    private String time;
    private String tutor;
    private String venue;
    private String day;

    public Timetable(String course, String time,String Venue,String Tutor,String day) {
        this.course = course;
        this.time = time;
        this.venue=Venue;
        this.tutor=Tutor;
        this.day=day;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getTutor() {
        return tutor;
    }

    public String getVenue() {
        return venue;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public String getCourse() {
        return course;
    }
}
