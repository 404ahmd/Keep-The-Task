package com.ahmadibrahim.keepthetask.Model;

public class Task {
    private int id;
    private String date;
    private String course;
    private String meeting;
    private String deadline;
    private String status;

    // empty cosntructor
    public Task(){}

    // constructor
    public Task(int id, String date, String course, String meeting, String deadline, String status){
        this.id = id;
        this.date = date;
        this.course = course;
        this.meeting = meeting;
        this.deadline = deadline;
        this.status = status;
    }

    // getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
