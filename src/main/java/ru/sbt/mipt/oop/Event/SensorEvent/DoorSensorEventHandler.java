package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Door;
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
            case LIGHT_ON:
                break;
            case LIGHT_OFF:
                break;
            case DOOR_OPEN:
                smartHome.execute(door_ -> {
                    if (door_ instanceof Door) {
                        Door door = (Door) door_;

                        if (door.getId().equals(event.getObjectId())) {
                            door.setOpen(true);
                            System.out.println("Door " + door.getId() + " in room " + door.getRoomName() + " was opened.");
                        }
                    }
                });
                break;

            case DOOR_CLOSED:
                smartHome.execute(door_ -> {
                    if (door_ instanceof Door) {
                        Door door = (Door) door_;

                        if (door.getId().equals(event.getObjectId())) {
                            door.setOpen(false);
                            System.out.println("Door " + door.getId() + " in room " + door.getRoomName() + " was closed.");
                        }
                    }
                });
                break;
        }
    }
}

