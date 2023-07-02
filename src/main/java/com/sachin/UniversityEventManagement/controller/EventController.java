package com.sachin.UniversityEventManagement.controller;

import com.sachin.UniversityEventManagement.model.Event;
import com.sachin.UniversityEventManagement.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<Event> addEvent(@Valid @RequestBody Event event) {
        Event savedEvent = eventService.addEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEvent);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable Long eventId,
            @Valid @RequestBody Event event
    ) {
        Event updatedEvent = eventService.updateEvent(eventId, event);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Event>> getAllEventsByDate(@PathVariable LocalDate date) {
        List<Event> events = eventService.getAllEventsByDate(date);
        return ResponseEntity.ok(events);
    }
}

