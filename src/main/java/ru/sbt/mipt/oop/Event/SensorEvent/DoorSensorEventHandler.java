package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Event.CommandSender;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import static ru.sbt.mipt.oop.ActionType.CLOSE_THE_DOOR;
import static ru.sbt.mipt.oop.ActionType.OPEN_THE_DOOR;
import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.DOOR_OPEN;

public class DoorSensorEventHandler implements EventHandler {

    static SmartHome smartHome;
    static CommandSender sender;
    public DoorSensorEventHandler(SmartHome smartHome, CommandSender sender){
        this.smartHome = smartHome;
        this.sender = sender;
    }

    @Override
    public void handleEvent(Object event_) {
        SensorEvent event = (SensorEvent) event_;
        switch (event.getType()) {
            case DOOR_OPEN:
                smartHome.execute(new Action(OPEN_THE_DOOR, event.getObjectId()));
                break;

            case DOOR_CLOSED:
                smartHome.execute(new Action(CLOSE_THE_DOOR, event.getObjectId()));
                break;
        }
    }
}

