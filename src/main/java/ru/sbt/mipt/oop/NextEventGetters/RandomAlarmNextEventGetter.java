package ru.sbt.mipt.oop.NextEventGetters;

import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;

import java.util.ArrayList;

import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.ALARM_TURNED_ON;

public class RandomAlarmNextEventGetter extends NextEventGetter {
    public RandomAlarmNextEventGetter() {
        this.eventGetters = new ArrayList<>();
    }

    RandomAlarmNextEventGetter(ArrayList<NextEventGetter> a) {
        super(a);
    }

    @Override
    /* todo add normal random */
    public SensorEvent getNextSensorEvent(){
        return new SensorEvent(ALARM_TURNED_ON);
    }

}