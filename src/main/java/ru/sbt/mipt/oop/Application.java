package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Event.*;
import ru.sbt.mipt.oop.Event.SensorEvent.*;
import ru.sbt.mipt.oop.Event.SensorEvent.AlarmEventHandler;
import ru.sbt.mipt.oop.NextEventGetters.NextEventGetter;
import ru.sbt.mipt.oop.NextEventGetters.RandomAlarmNextEventGetter;
import ru.sbt.mipt.oop.NextEventGetters.RandomSensorNextEventGetter;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.SmartHome.SmartHomeGsonReader;
import ru.sbt.mipt.oop.SmartHome.SmartHomeReader;
import ru.sbt.mipt.oop.events.SensorEventsManager;

import java.util.ArrayList;
import java.util.Collection;

public class Application{
    public static void main(String... args) {
        SmartHome smartHome = getSmartHome();
        Collection<EventHandler> handlers = setEventHandlers(smartHome);
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        registerEventHandlers(sensorEventsManager, handlers);
        sensorEventsManager.start();

        /* todo add password to alarm */
        /* todo rewrite Adaptor */
        /* todo do missed hw */
        /* todo add spring impl */
    }

    private static void registerEventHandlers(SensorEventsManager sensorEventsManager, Collection<EventHandler> handlers) {
        for(EventHandler handler: handlers) {
            SensorEventHandlerApiAdapter apiAdapter = new SensorEventHandlerApiAdapter(handler);
            sensorEventsManager.registerEventHandler(event_ -> apiAdapter.handle(event_));
        }
    }

    private static SmartHome getSmartHome() {
        SmartHomeReader reader = new SmartHomeGsonReader("smart-home-1.js");
        return reader.Read();
    }

    private static ArrayList<NextEventGetter> setNextEventGetters() {
        ArrayList<NextEventGetter> nextEventGetters = new ArrayList<>();
        nextEventGetters.add(new RandomSensorNextEventGetter());
        nextEventGetters.add(new RandomAlarmNextEventGetter());
        return nextEventGetters;
    }

    private static Collection<EventHandler> setEventHandlers(SmartHome smartHome) {
        Collection<EventHandler> handlers = new ArrayList<>();
        CommandSender sender = new IOCommandSender();
        Alarm alarm = new Alarm(smartHome);

        handlers.add(new SecurityHandlerDecorator(new HandlerDecorator(new DoorSensorEventHandler(smartHome, sender)), alarm));
        handlers.add(new SecurityHandlerDecorator(new HandlerDecorator(new LightSensorEventHandler(smartHome)), alarm));
        handlers.add(new SecurityHandlerDecorator(new HandlerDecorator(new HallEventHandler(smartHome, sender)), alarm));

        handlers.add(new AlarmEventHandler(alarm));
        return handlers;
    }
}
