package net.javaguides.evms.service;

import net.javaguides.evms.dto.EventDto;

import java.util.List;

public interface EventService {
    EventDto createEvent(EventDto eventDto);

    EventDto getEventById(Long eventId);

    List<EventDto> getAllEvents();

    EventDto updateEvent(Long eventId ,EventDto updatedEvent);

    void deleteEvent (Long eventId);



}
