package ru.sbt.mipt.oop;

public class Action {
    ActionType type;
    String objectId;
    public Action(ActionType type, String objectId) {
        this.type = type;
        this.objectId = objectId;
    }
    public ActionType getType() {
        return type;
    }

    public String getObjectId() {
        return objectId;
    }

    public String toString() {
        return "SensorEvent{" +
                "type=" + type +
                ", objectId='" + objectId + '\'' +
                '}';
    }

}
