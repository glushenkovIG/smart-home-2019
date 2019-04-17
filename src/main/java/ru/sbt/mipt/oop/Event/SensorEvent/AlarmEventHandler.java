package ru.sbt.mipt.oop.Event.SensorEvent;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Event.EventHandler;

public class AlarmEventHandler implements EventHandler {
    private Alarm alarm;

    public AlarmEventHandler(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void handleEvent(Object o) {
        SensorEvent event = (SensorEvent) o;
        assert event != null;
        switch(event.getType()){
            case ALARM_TURNED_ON:
                alarm.activate(alarm.getPassword());
                break;
            case ALARM_TURNED_OFF:
                alarm.deActivate(alarm.getPassword());
                break;
            default:
                alarm.switchToShoutingMode();
                break;

        }
    }
}
