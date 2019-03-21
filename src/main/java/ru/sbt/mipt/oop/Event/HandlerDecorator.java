package ru.sbt.mipt.oop.Event;

public class HandlerDecorator implements EventHandler {
    EventHandler handler;

    public HandlerDecorator(EventHandler handler){
        this.handler = handler;
    }

    @Override
    public void handleEvent(Object o) {
        handler.handleEvent(o);
    }
}
