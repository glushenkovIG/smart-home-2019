package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.LIGHT_ON;

public class LightSensorEventHandler implements EventHandler {
    static SmartHome smartHome;
    public LightSensorEventHandler(SmartHome smartHome_){
        smartHome = smartHome_;
    }

    public void handleEvent(Object event_) {
        SensorEvent event = (SensorEvent) event_;
        if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
            // событие от источника света
            for (Room room : smartHome.getRooms()) {
                for (Light light : room.getLights()) {
                    if (light.getId().equals(event.getObjectId())) {
                        if (event.getType() == LIGHT_ON) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                        } else {
                            light.setOn(false);
                            System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                        }
                    }
                }
            }
        }
    }
}
