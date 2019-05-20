package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;
import ru.sbt.mipt.oop.events.CCSensorEvent;

public class SensorEventHandlerApiAdapter {
    EventHandler handler;

    SensorEventHandlerApiAdapter(EventHandler handler){
        this.handler = handler;
    }

    void handle(Object event_){
        try {
            SensorEvent event = ApiEvent2SensorEventAdaptor.adapt(event_);
            handler.handleEvent(event);
        } catch (ClassCastException e){
            System.out.println("Type <" + ((CCSensorEvent) event_).getEventType() + "> is not supported.");
        }
    }
}
