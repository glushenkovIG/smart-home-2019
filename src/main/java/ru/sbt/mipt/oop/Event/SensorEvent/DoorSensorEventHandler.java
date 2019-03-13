package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.Event.CommandSender;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome.DoorsIterator;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.SmartHome.myIterator;

import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.DOOR_OPEN;

public class DoorSensorEventHandler implements EventHandler {

    static SmartHome smartHome;
    static CommandSender sender;
    public DoorSensorEventHandler(SmartHome smartHome_, CommandSender sender_){
        smartHome = smartHome_;
        sender = sender_;
    }

    @Override
    public void handleEvent(Object event_) {
        SensorEvent event = (SensorEvent) event_;
        if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
            //DoorsIterator iterator = new DoorsIterator(smartHome);
            for(Room room: smartHome.getRooms()){
                for(Door door: room.getDoors()){
                    processDoor(event, room, door);
                }
            }
//            while(iterator.hasNext()){
//                processDoor(event, iterator.getroom(), iterator.next());
//            }
        }
    }

    private void processDoor(SensorEvent event, Room room, Door door) {
        if (door.getId().equals(event.getObjectId())) {
            if (event.getType() == DOOR_OPEN) {
                door.setOpen(true);
                System.out.println("Door " + door.getId() + " in room " + room.getName() + " was opened.");
            } else {
                door.setOpen(false);
                System.out.println("Door " + door.getId() + " in room " + room.getName() + " was closed.");
                // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
            }
        }
    }
}

