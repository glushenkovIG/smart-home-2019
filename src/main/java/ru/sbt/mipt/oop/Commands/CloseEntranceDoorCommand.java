package ru.sbt.mipt.oop.Commands;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.SmartHome.Door;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.SmartHomeIterators.DoorsIterator;
import ru.sbt.mipt.oop.SmartHomeIterators.LightIterator;

public class CloseEntranceDoorCommand extends Command {
    public CloseEntranceDoorCommand(SmartHome smartHome, Alarm alarm) {
        super(smartHome, alarm);
    }

    @Override
    public void execute() {
        DoorsIterator iterator = new DoorsIterator(smartHome);
        Door door;
        while(iterator.hasNext()){
            door = iterator.next();
            if(door.getRoomName().equals("Hall")){
                iterator.next().setOpen(false);
            }
        }
    }
}
