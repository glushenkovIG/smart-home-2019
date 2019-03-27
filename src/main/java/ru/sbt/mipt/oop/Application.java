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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class Application{
    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        SmartHomeReader reader = new SmartHomeGsonReader("smart-home-1.js");
        SmartHome smartHome = reader.Read();

        ////////////////////////////////////////////////////////////
        // добавляем обработчики для возможных событий в коллекцию
        Collection<EventHandler> handlers = setEventHandlers(smartHome);

        // начинаем цикл обработки событий
        ArrayList<NextEventGetter> nextEventGetters = setNextEventGetters();

        NextEventGetter nextEventGetter = new NextEventGetter(nextEventGetters);
        SensorEvent event = nextEventGetter.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for(EventHandler handler: handlers){
                handler.handleEvent(event);
            }
            event = nextEventGetter.getNextSensorEvent();
        }

        /////
        SensorEventApiAdapter apiHandler = new SensorEventApiAdapter(setEventHandlers(smartHome));
        /////
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(event_ -> apiHandler.handle(event_));
        sensorEventsManager.start();
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
