package ru.sbt.mipt.oop.Commands;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.SmartHome.Light;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.SmartHomeIterators.LightIterator;

public class TurnCorridorLightOnCommand extends Command {
    TurnCorridorLightOnCommand(SmartHome smartHome, Alarm alarm) {
        super(smartHome, alarm);
    }

    @Override
    public void execute() {
        LightIterator iterator = new LightIterator(smartHome);
        Light light;
        while(iterator.hasNext()){
            light = iterator.next();
            if(light.getRoomName().equals("Corridor")){
                light.setOn(true);
            }
        }
    }
}