
package kz.iitu.registration.controller;

import kz.iitu.registration.entity.Event;
import kz.iitu.registration.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // GET: Get all events or search by title
    @GetMapping
    public List<Event> getAllEvents(
            @RequestParam(required = false) String title) {

        if (title != null && !title.isBlank()) {
            return eventService.searchEvents(title);
        }

        return eventService.getAllEvents();
    }

    // GET: Get event by ID
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(
            @PathVariable Long id) {

        return eventService.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Create a new event
    @PostMapping
    public ResponseEntity<Event> addEvent(
            @RequestBody(required = false) Event event) {

        if (!isValidEvent(event)) {
            return ResponseEntity.badRequest().build();
        }

        Event savedEvent = eventService.addEvent(event);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedEvent);
    }

    // PUT: Update an existing event
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(
            @PathVariable Long id,
            @RequestBody(required = false) Event event) {

        if (!isValidEvent(event)) {
            return ResponseEntity.badRequest().build();
        }

        return eventService.updateEvent(id, event)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE: Delete an event
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(
            @PathVariable Long id) {

        if (!eventService.deleteEvent(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    // Validate event data
    private boolean isValidEvent(Event event) {
        return event != null
                && event.getTitle() != null
                && !event.getTitle().isBlank()
                && event.getLocation() != null
                && !event.getLocation().isBlank();
    }
}
