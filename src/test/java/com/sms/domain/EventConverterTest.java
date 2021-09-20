package com.sms.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class EventConverterTest {
    private static final String APPLICATION_LOG = "APPLICATION_LOG";
    private static final String ID = "123a";
    private static final String HOST_1 = "HOST1";
    private EventConverter eventConverter = new EventConverter();

    @Test
    public void testEventDTOToEvent_NonAlertEvent() {
        EventDto start = new EventDto(ID, EventDto.State.STARTED, APPLICATION_LOG, HOST_1, 123L);
        EventDto finish = new EventDto(ID, EventDto.State.FINISHED, APPLICATION_LOG, HOST_1, 124L);

        Event event = eventConverter.EventDTOToEvent(start, finish);
        assertFalse("Event should not be returned as alert", event.isAlert());
    }

    @Test
    public void testEventDTOToEvent_AlertEvent() {
        EventDto start = new EventDto(ID, EventDto.State.STARTED, APPLICATION_LOG, HOST_1, 123L);
        EventDto finish = new EventDto(ID, EventDto.State.FINISHED, APPLICATION_LOG, HOST_1, 128L);

        Event event = eventConverter.EventDTOToEvent(start, finish);
        assertTrue("Event should be returned as alert", event.isAlert());
    }
}