package com.company.controllers;

import com.company.entities.Event;
import com.company.repositories.interfaces.IEventRepositories;

public class AdminController {
    private final IEventRepositories eventRepositories;
    public AdminController(IEventRepositories eventRepositories){
        this.eventRepositories = eventRepositories;
    }
    public String CreateEvent(String name, double price, String description){
        Event event = new Event(name, price, description);
        boolean created = eventRepositories.CreateEvent(event);
        return (created ? "Event was created" : "Event creation was failed!");
    }
}
