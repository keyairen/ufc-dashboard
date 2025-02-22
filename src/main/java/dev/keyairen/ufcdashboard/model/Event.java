package dev.keyairen.ufcdashboard.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String eventName;
    private String eventLocation;
    private LocalDate eventDate;

    @Transient
    private List<Fight> eventFights;

    public Event(String eventName, String eventLocation, LocalDate eventDate) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventDate = eventDate;
    }

    public Event() {}

    @Override
    public String toString() {
        return "Event{" +
                "eventName=" + eventName +
                ", eventLocation=" + eventLocation +
                ", eventDate=" + eventDate + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public List<Fight> getEventFights() {
        return eventFights;
    }

    public void setEventFights(List<Fight> eventFights) {
        this.eventFights = eventFights;
    }
}
