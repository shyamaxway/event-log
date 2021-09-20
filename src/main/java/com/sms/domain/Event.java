package com.sms.domain;

import java.util.Objects;

public class Event {

    private String id;
    private final Long duration;
    private String type;
    private String host;
    private final boolean alert;

    Event(String id, Long duration, String type, String host, boolean alert) {
        this.id = id;
        this.duration = duration;
        this.type = type;
        this.host = host;
        this.alert = alert;
    }

    public String getId() {
        return id;
    }

    public Long getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

    public String getHost() {
        return host;
    }

    public boolean isAlert() {
        return alert;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return alert == event.alert &&
                Objects.equals(id, event.id) &&
                Objects.equals(duration, event.duration) &&
                Objects.equals(type, event.type) &&
                Objects.equals(host, event.host);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, duration, type, host, alert);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", duration=" + duration +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", alert=" + alert +
                '}';
    }
}
