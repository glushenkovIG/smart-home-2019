package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Event.EventSender;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.*;

public class SensorEventHandler implements EventHandler {

    public void HandleEvent(SmartHome smartHome, Object event_, EventSender sender) {
        SensorEvent event = (SensorEvent) event_;
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            // событие от источника света
            LightSensorEventHandler.handleLight(smartHome, event);
        }
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            // событие от двери
            DoorSensorEventHandler.handleDoor(smartHome, event, sender);
        }
    }
}
