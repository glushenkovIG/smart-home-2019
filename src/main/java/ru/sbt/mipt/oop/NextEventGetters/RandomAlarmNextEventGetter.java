package ru.sbt.mipt.oop.NextEventGetters;

import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;

import java.util.ArrayList;

import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.ALARM_TURNED_ON;

public class RandomAlarmNextEventGetter extends NextEventGetter {
    public RandomAlarmNextEventGetter() {
        super();
    }

    RandomAlarmNextEventGetter(ArrayList<NextEventGetter> a) {
        super(a);
    }

    public static SensorEvent getNextSensorEvent() {
        return new SensorEvent(ALARM_TURNED_ON);
    }
}