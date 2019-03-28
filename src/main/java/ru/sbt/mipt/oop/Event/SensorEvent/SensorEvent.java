package ru.sbt.mipt.oop.Event.SensorEvent;


import ru.sbt.mipt.oop.Event.Event;

public class SensorEvent implements Event {
    private final SensorEventType type;
    private final String objectId;

    public SensorEvent(SensorEventType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }
    public SensorEvent(SensorEventType type){
        this.type = type;
        this.objectId = null;
    }

    public SensorEvent() {
        this.type = null;
        this.objectId = null;
    }

    public SensorEventType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    @Override
    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }
}
