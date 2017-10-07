package com.shahab.mateAcademy.SpringBoot.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Integer id;

    private Date date;

    @Size(min=2, message="Event name should have atleast 2 characters")
    @ApiModelProperty(notes="Event name should have atleast 2 characters")
    private String eventName;

    private Time startTime;

    private Time endTime;


    @Size(min=2, message="Event description should have atleast 2 characters")
    @ApiModelProperty(notes="Event description should have atleast 2 characters")
    private String eventDescription;

    protected Event(){

    }

    public Event(Integer id, Date date, String eventName, Time startTime, Time endTime, String eventDescription) {
        super();
        this.id = id;
        this.date = date;
        this.eventName = eventName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventDescription = eventDescription;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEventDate() {
        return date;
    }

    public void setEventDate(Date date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, date=%s, eventName=%s, startTime=%s, endTime=%s, eventDescription=%s]", id, date, eventName, startTime, endTime, eventDescription);
    }

}
