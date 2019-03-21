package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

public class LightSensorEventHandler implements EventHandler {
    static SmartHome smartHome;
    public LightSensorEventHandler(SmartHome smartHome_){
        smartHome = smartHome_;
    }

    public void handleEvent(Object event_) {
        SensorEvent event = (SensorEvent) event_;
        switch (event.getType()) {
            case LIGHT_ON:
                smartHome.execute(light_ -> {
                    if (light_ instanceof Light) {
                        Light light = (Light) light_;

                        if (light.getId().equals(event.getObjectId())) {
                            light.setOn(true);
                            System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was set on.");
                        }
                    }
                });
                break;

            case LIGHT_OFF:
                smartHome.execute(light_ -> {
                    if (light_ instanceof Light) {
                        Light light = (Light) light_;

                        if (light.getId().equals(event.getObjectId())) {
                            light.setOn(false);
                            System.out.println("Light " + light.getId() + " in room " + light.getRoomName() + " was set off.");
                        }
                    }
                });
                break;
        }
    }
}
