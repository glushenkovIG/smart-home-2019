package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.CommandType;
import ru.sbt.mipt.oop.Event.CommandSender;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome.SmartHome;


public class HallEventHandler implements EventHandler {
    SmartHome smartHome;
    CommandSender sender;
    public HallEventHandler(SmartHome smartHome_, CommandSender sender_){
        smartHome = smartHome_;
        sender = sender_;
    }

    @Override
    public void handleEvent(Object o) {
            for (Room homeRoom : smartHome.getRooms()) {
                for (Light light : homeRoom.getLights()) {
                    light.setOn(false);
                    SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                    sender.sendCommand(command);
                }
        }
    }
}
