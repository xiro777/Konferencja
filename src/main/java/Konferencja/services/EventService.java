package Konferencja.services;

import Konferencja.db_classes.Event;
import Konferencja.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {

    final private EventRepository eventRepository;

    @Autowired
    public EventService (EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    public Optional<Event> getEvent(String eventName)
    {
        return eventRepository.findEventByEventName(eventName);
    }

    public void addNewEvent(Event event) {
        eventRepository.save(event);
    }

    public void deleteEvent(Long eventID) {
        boolean exists = eventRepository.existsById(eventID);
        if(!exists){
            throw new IllegalStateException("event with id " + eventID + " does not exsist!");
        }
        else
        {
            eventRepository.deleteById(eventID);
        }
    }
}