package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;

public class HandlerDecorator implements EventHandler {
    EventHandler handler;

    public HandlerDecorator(EventHandler handler){
        this.handler = handler;
    }

    @Override
    public void handleEvent(Object o) {
        if(((SensorEvent) o).getType() != null) {
            handler.handleEvent(o);
        }
    }
}
