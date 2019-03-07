package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.CommandType;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Event.EventSender;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.DOOR_OPEN;

public class DoorSensorEventHandler {
    public static void handleDoor(SmartHome smartHome, SensorEvent event, EventSender sender) {
        for (Room room : smartHome.getRooms()) {
            for (Door door : room.getDoors()) {
                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                        // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                        // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                        if (room.getName().equals("hall")) {
                            for (Room homeRoom : smartHome.getRooms()) {
                                for (Light light : homeRoom.getLights()) {
                                    light.setOn(false);
                                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                                    sender.sendCommand(command);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

