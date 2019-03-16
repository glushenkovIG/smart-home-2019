package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.*;
import ru.sbt.mipt.oop.Event.CommandSender;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.SmartHome.LightIterator;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import static ru.sbt.mipt.oop.ActionType.*;
import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.DOOR_CLOSED;


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
        if(event.getType() == DOOR_CLOSED & smartHome.getDoorByID(event.getObjectId()).getRoomName().equals("hall")){
            turnOffAllLight();
        }
    }

    private void turnOffAllLight() {
        LightIterator lightIterator = new LightIterator(smartHome);
        while(lightIterator.hasNext()) {
            smartHome.execute(new Action(TURN_OFF_LIGHT, lightIterator.next().getId()));
        }
    }
}
