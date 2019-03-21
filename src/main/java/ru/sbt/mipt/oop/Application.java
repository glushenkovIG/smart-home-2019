package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Event.*;
import ru.sbt.mipt.oop.Event.SensorEvent.*;
import ru.sbt.mipt.oop.SmartHome.AlarmEventHandler;
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
        CommandSender sender = new IOCommandSender();


        ////////////////////////////////////////////////////////////
        // добавляем обработчики для возможных событий в коллекцию

        SmartHome smartHome = reader.Read();
        Collection<EventHandler> handlers = new ArrayList<>();
        Alarm alarm = new Alarm(smartHome);
        handlers.add(new SecurityHandlerDecorator(new HandlerDecorator(new DoorSensorEventHandler(smartHome, sender)), alarm));
        handlers.add(new SecurityHandlerDecorator(new HandlerDecorator(new LightSensorEventHandler(smartHome)), alarm));
        handlers.add(new SecurityHandlerDecorator(new HandlerDecorator(new HallEventHandler(smartHome, sender)), alarm));

        handlers.add(new AlarmEventHandler(alarm));

        // начинаем цикл обработки событий

        SensorEvent event = RandomNextEventGetter.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for(EventHandler handler: handlers){
                handler.handleEvent(event);
            }

            event = RandomNextEventGetter.getNextSensorEvent();
        }
    }
}
