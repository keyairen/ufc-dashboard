package dev.keyairen.ufcdashboard.Repository;

import dev.keyairen.ufcdashboard.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
public interface EventRepository extends JpaRepository<Event, String>{

    Event findByEventName(String eventName);

    List<Event> findAllByOrderByEventDateDesc();
}
