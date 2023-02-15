package com.company.repositories.interfaces;

import com.company.entities.Event;

import java.util.List;

public interface IEventRepositories {
    boolean CreateEvent(Event event);

    List<Event> getAllEvents();

}
