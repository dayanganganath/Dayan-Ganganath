package net.javaguides.evms.repository;

import net.javaguides.evms.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
