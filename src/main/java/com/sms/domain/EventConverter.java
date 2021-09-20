package com.sms.domain;

import org.springframework.stereotype.Component;

@Component
public class EventConverter {
    /**
     * Takes eventDTO start and finish objects and calculates (non)alert event based on elapsed timestamp
     *
     * @param startEvent
     * @param finishEvent
     * @return Event object
     */
    public Event EventDTOToEvent(EventDto startEvent, EventDto finishEvent) {
        Long duration =  finishEvent.getTimestamp() - startEvent.getTimestamp();
        boolean isAlert = duration > 4;
        return new Event(startEvent.getId(), duration, startEvent.getType(), startEvent.getHost(), isAlert);
    }
}
