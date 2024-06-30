package net.javaguides.evms.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.evms.dto.EventDto;
import net.javaguides.evms.entity.Event;
import net.javaguides.evms.exception.ResourceNotFoundException;
import net.javaguides.evms.mapper.EventMapper;
import net.javaguides.evms.repository.EventRepository;
import net.javaguides.evms.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventServiceImpl  implements EventService {

    private EventRepository eventRepository;

    @Override
    public EventDto createEvent(EventDto eventDto) {

        Event event = EventMapper.mapToEvent(eventDto);
        Event savedEvent = eventRepository.save(event);
        return EventMapper.mapToEventDto(savedEvent);
    }

    @Override
    public EventDto getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Event is not exists with given id : " + eventId));
        return EventMapper.mapToEventDto(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map((event) -> EventMapper.mapToEventDto(event))
                .collect(Collectors.toList());
    }

    @Override
    public EventDto updateEvent(Long eventId, EventDto updateEvent) {

        Event event = eventRepository.findById(eventId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + eventId)
        );

        event.setFirstName(updateEvent.getFirstName());
        event.setLastName(updateEvent.getLastName());
        event.setEmail(updateEvent.getEmail());
        event.setEventName(updateEvent.getEventName());
        event.setEventVenue(updateEvent.getEventVenue());
        event.setEventPrice(updateEvent.getEventPrice());

        Event updatedEventObj = eventRepository.save(event);


        return EventMapper.mapToEventDto(updatedEventObj);
    }

    @Override
    public void deleteEvent(Long eventId) {

        Event event = eventRepository.findById(eventId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + eventId)
        );
        eventRepository.deleteById(eventId);
    }
}
