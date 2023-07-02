package com.sachin.UniversityEventManagement.services;

import com.sachin.UniversityEventManagement.model.Event;
import com.sachin.UniversityEventManagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long eventId, Event event) {
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        if (optionalEvent.isPresent()) {
            Event existingEvent = optionalEvent.get();
            existingEvent.setEventName(event.getEventName());
            existingEvent.setLocationOfEvent(event.getLocationOfEvent());
            existingEvent.setStartTime(event.getStartTime());
            existingEvent.setEndTime(event.getEndTime());
            existingEvent.setDate(event.getDate());
            return eventRepository.save(existingEvent);
        }
        throw new IllegalArgumentException("Event not found with ID: " + eventId);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    public List<Event> getAllEventsByDate(LocalDate date) {
        return eventRepository.findByDate(date);
    }
}

