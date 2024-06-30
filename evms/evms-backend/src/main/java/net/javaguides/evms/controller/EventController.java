package net.javaguides.evms.controller;

import lombok.AllArgsConstructor;
import net.javaguides.evms.dto.EventDto;
import net.javaguides.evms.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/events")

public class EventController {
    private EventService eventService;

    //Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EventDto> createEvent(@RequestBody EventDto eventDto){
        EventDto savedEvent = eventService.createEvent(eventDto);
        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    //Build get event REST API
    @GetMapping("{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable("id") Long eventId){
        EventDto eventDto = eventService.getEventById(eventId);
        return ResponseEntity.ok(eventDto);
    }

    //Build get All Event PEST API
    @GetMapping
    public ResponseEntity<List<EventDto>> getAllEvents(){
        List<EventDto> events = eventService.getAllEvents();
        return  ResponseEntity.ok(events);
    }

    //Build Update Event REST API
    @PutMapping("{id}")
    public  ResponseEntity<EventDto> updateEvent(@PathVariable("id") Long eventId,
                                                 @RequestBody EventDto updatedEvent){
        EventDto eventDto = eventService.updateEvent(eventId, updatedEvent);
        return  ResponseEntity.ok(eventDto);
    }

    //Build Delete Event REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable("id") Long eventId){
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok("Event deleted Successfully!!.");
    }
}
