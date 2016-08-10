package com.apsoft.rxmvp.sample.eventbus.events;

public class SaySomethingEvent {

    private String message;

    public SaySomethingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
