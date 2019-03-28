package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Event.EventHandler;

public class AlarmEventHandler implements EventHandler {
    Alarm alarm;

    public AlarmEventHandler(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void handleEvent(Object o) {
        SensorEvent event = (SensorEvent) o;
        if (event == null | event.getType() == null){
            return;
        }
        switch(event.getType()){
            case ALARM_TURNED_ON:
                alarm.activate();
            case ALARM_TURNED_OFF:
                alarm.deActivate();
            default:
                alarm.switchToShoutingMode();

        }
    }
}
