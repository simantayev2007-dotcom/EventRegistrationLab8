
package kz.iitu.registration.service;

import kz.iitu.registration.entity.Event;
import kz.iitu.registration.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> searchEvents(String title) {
        return eventRepository.findByTitleContainingIgnoreCase(title);
    }

    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public Optional<Event> updateEvent(Long id, Event updatedEvent) {
        return eventRepository.findById(id).map(event -> {
            event.setTitle(updatedEvent.getTitle());
            event.setLocation(updatedEvent.getLocation());
            return eventRepository.save(event);
        });
    }

    public boolean deleteEvent(Long id) {
        if (!eventRepository.existsById(id)) {
            return false;
        }

        eventRepository.deleteById(id);
        return true;
    }
}
