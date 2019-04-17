package ru.sbt.mipt.oop;


/*

package com.coolcompany.smarthome.sample;

import com.coolcompany.smarthome.events.SensorEventsManager;

public class Sample {

    public static void main(String[] args) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(event -> {
            System.out.println("Event type [" + event.getEventType() + "] from object with id=" + event.getObjectId() + "]");
        });
        sensorEventsManager.start();
    }
}
 */

import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;

import java.util.Collection;

public class SensorEventHandlerApiAdapter {
    EventHandler handler;

    SensorEventHandlerApiAdapter(EventHandler handler){
        this.handler = handler;
    }

    void handle(Object event_){
        SensorEvent event = ApiEvent2SensorEventAdaptor.adapt(event_);
        handler.handleEvent(event);
    }
}
