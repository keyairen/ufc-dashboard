package dev.keyairen.ufcdashboard.Controller;

import dev.keyairen.ufcdashboard.Repository.EventRepository;
import dev.keyairen.ufcdashboard.Repository.FightRepository;
import dev.keyairen.ufcdashboard.model.Event;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EventController {

    private final EventRepository eventRepository;
    private final FightRepository fightRepository;

    public EventController(EventRepository eventRepository, FightRepository fightRepository) {
        this.eventRepository = eventRepository;
        this.fightRepository = fightRepository;
    }

    @GetMapping("/events")
    public List<Event> getAllEvents() {
        return this.eventRepository.findAllByOrderByEventDateDesc();
    }

    @GetMapping("/events/{eventName}")
    public Event getEvent(@PathVariable String eventName) {
        Event event = this.eventRepository.findByEventName(eventName);
        event.setEventFights(fightRepository.getFightsByEventName(eventName));
        return event;
    }
}
