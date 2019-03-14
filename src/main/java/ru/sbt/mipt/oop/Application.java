package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Event.CommandSender;
import ru.sbt.mipt.oop.Event.IOCommandSender;
import ru.sbt.mipt.oop.Event.SensorEvent.*;
import ru.sbt.mipt.oop.SmartHome.DoorsIterator;
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

        SensorEvent event = RandomNextEventGetter.getNextSensorEvent();
        CommandSender sender = new IOCommandSender();


        ////////////////////////////////////////////////////////////
        // добавляем обработчики для возможных событий в коллекцию
        Collection<EventHandler> handlers = new ArrayList<>();
        handlers.add(new DoorSensorEventHandler(smartHome, sender));
        handlers.add(new LightSensorEventHandler(smartHome));

        // начинаем цикл обработки событий

        while (event != null) {
            System.out.println("Got event: " + event);
            for(EventHandler handler: handlers){
                handler.handleEvent(event);
            }
            event = RandomNextEventGetter.getNextSensorEvent();
        }
        ////////////////////////////////////////////////////////////
        // TODO: make above code equivalent to the code below
        /*
        smartHome.execute(event);
        */
    }
}
