package ru.sbt.mipt.oop.NextEventGetters;

import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType;

public class RandomSensorNextEventGetter extends NextEventGetter {

    @Override
    public SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) return null; // null means end of event stream
        SensorEventType sensorEventType = SensorEventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (1 + 3 * Math.random()));
        return new SensorEvent(sensorEventType, objectId);
    }
}
