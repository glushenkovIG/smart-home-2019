package ru.sbt.mipt.oop.Commands;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.SmartHomeIterators.LightIterator;

public class TurnAllLightOnCommand extends Command {

    public TurnAllLightOnCommand(SmartHome smartHome, Alarm alarm) {
        super(smartHome, alarm);
    }

    @Override
    public void execute() {
        LightIterator iterator = new LightIterator(smartHome);
        while(iterator.hasNext()){
            iterator.next().setOn(true);
        }
    }
}
