package net.javaguides.evms.mapper;

import net.javaguides.evms.dto.EventDto;
import net.javaguides.evms.entity.Event;

public class EventMapper {
    public static EventDto mapToEventDto(Event event){
        return new EventDto(
                event.getId(),
                event.getFirstName(),
                event.getLastName(),
                event.getEmail(),
                event.getEventName(),
                event.getEventVenue(),
                event.getEventPrice()
        );

    }

    public static Event mapToEvent(EventDto eventDto){
        return new Event(
                eventDto.getId(),
                eventDto.getFirstName(),
                eventDto.getLastName(),
                eventDto.getEmail(),
                eventDto.getEventName(),
                eventDto.getEventVenue(),
                eventDto.getEventPrice()
        );
    }
}
