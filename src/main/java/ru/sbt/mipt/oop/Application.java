package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Event.EventSender;
import ru.sbt.mipt.oop.Event.IOEventSender;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEventHandler;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.SmartHome.SmartHomeGsonReader;
import ru.sbt.mipt.oop.SmartHome.SmartHomeReader;

import java.io.IOException;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHomeReader reader = new SmartHomeGsonReader();
        SmartHome smartHome = reader.Read("smart-home-1.js");

        // начинаем цикл обработки событий
        SensorEvent event = getNextSensorEvent();
        EventHandler handler = new SensorEventHandler();
        EventSender sender = new IOEventSender();

        while (event != null) {
            System.out.println("Got event: " + event);
            handler.HandleEvent(smartHome, event, sender);
            event = getNextSensorEvent();
        }
    }
/*
    private static void sendCommand(SensorCommand command) {
        System.out.println("Pretent we're sending command " + command);
    }
    */

    private static SensorEvent getNextSensorEvent() {

        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
