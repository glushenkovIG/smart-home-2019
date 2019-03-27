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

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Handler;

public class SensorEventApiAdapter {
    Collection<EventHandler> handlers;

    SensorEventApiAdapter(Collection<EventHandler> handlers){
        this.handlers = handlers;
    }

    void handle(Object event){
        for(EventHandler handler: handlers){
            handler.handleEvent(event);
        }
    }
}
