package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.Action;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

import static ru.sbt.mipt.oop.ActionType.*;
import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.LIGHT_ON;

public class LightSensorEventHandler implements EventHandler {
    static SmartHome smartHome;
    public LightSensorEventHandler(SmartHome smartHome_){
        smartHome = smartHome_;
    }

    public void handleEvent(Object event_) {
        SensorEvent event = (SensorEvent) event_;
        switch (event.getType()) {
            case LIGHT_ON:
                smartHome.execute(new Action(TURN_ON_LIGHT, event.getObjectId()));
                break;

            case LIGHT_OFF:
                smartHome.execute(new Action(TURN_OFF_LIGHT, event.getObjectId()));
                break;
        }
    }
}
