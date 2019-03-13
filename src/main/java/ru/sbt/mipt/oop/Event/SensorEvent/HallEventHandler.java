package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.CommandType;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Event.CommandSender;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.DOOR_OPEN;


public class HallEventHandler implements EventHandler {
    SmartHome smartHome;
    CommandSender sender;
    public HallEventHandler(SmartHome smartHome_, CommandSender sender_){
        smartHome = smartHome_;
        sender = sender_;
    }

    @Override
    public void handleEvent(Object o) {
        SensorEvent event = (SensorEvent) o;
        if (event.getType() == DOOR_CLOSED) {
            for (Room room : smartHome.getRooms()) {
                for (Door door : room.getDoors()) {
                    processDoor(event, room, door);
                }
            }
        }
    }

    private void processDoor(SensorEvent event, Room room, Door door) {
        if (door.getId().equals(event.getObjectId()) & room.getName().equals("hall")) {
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
