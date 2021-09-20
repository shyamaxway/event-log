package com.sms.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDto {
    private String id;
    private State state;
    private String type;
    private String host;
    private Long timestamp;

    @JsonCreator
    EventDto(@JsonProperty(value="id", required = true) String id, @JsonProperty(value="state", required = true) State state, @JsonProperty("type") String type,
        @JsonProperty("host") String host, @JsonProperty(value="timestamp", required = true) Long timestamp) {
        this.id = id;
        this.state = state;
        this.type = type;
        this.host = host;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public String getType() {
        return type;
    }

    public String getHost() {
        return host;
    }

    public Long getTimestamp() {
        return timestamp;
    }


    public enum State {
        @JsonProperty("STARTED")
        STARTED,
        @JsonProperty("FINISHED")
        FINISHED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventDto eventDto = (EventDto) o;
        return Objects.equals(id, eventDto.id) &&
                state == eventDto.state &&
                Objects.equals(type, eventDto.type) &&
                Objects.equals(host, eventDto.host) &&
                Objects.equals(timestamp, eventDto.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state, type, host, timestamp);
    }

    @Override
    public String toString() {
        return "EventDto{" +
                "id='" + id + '\'' +
                ", state=" + state +
                ", type='" + type + '\'' +
                ", host='" + host + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
