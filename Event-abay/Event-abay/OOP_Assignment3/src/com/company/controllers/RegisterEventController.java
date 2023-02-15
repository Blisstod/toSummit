package com.company.controllers;

import com.company.entities.Event;
import com.company.entities.User;

import java.util.ArrayList;
import java.util.List;

public class RegisterEventController {
    private List<Event> registeredEvents = new ArrayList<>();
    public RegisterEventController(){

    }
    public boolean registerEvent(Event event, User user){
        if(event.getPrice()<= user.getBalance()) {
            user.pay(event.getPrice());
            this.registeredEvents.add(event);
            return true;
        }
        return false;
    }
    public boolean refundEvent(Event eventToRefund, User user){
        boolean index = false;
        for (Event event : this.getRegisteredEvents()) {
            if (event.getId()==eventToRefund.getId()){
                index = true;
                break;
            }
        }
        if(index) {
            user.refund(eventToRefund.getPrice());
    //        this.registeredEvents.remove(event);
            List <Event> refundedEvents = new ArrayList<>();
            for (Event validEvent : registeredEvents) {
                if (validEvent.getId()!=eventToRefund.getId()){
                    refundedEvents.add(eventToRefund);
                }
            }
            setRegisteredEvents(refundedEvents);
            return true;
        }
        return false;
    }
    public List<Event> getRegisteredEvents (){
        return registeredEvents;
    }


    public void setRegisteredEvents(List<Event> registeredEvents) {
        this.registeredEvents = registeredEvents;
    }
}
