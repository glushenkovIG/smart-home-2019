package ru.sbt.mipt.oop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
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
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
        sensorEventsManager.start();
    }
}
