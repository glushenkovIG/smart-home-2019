package ru.sbt.mipt.oop.SmartHome;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Event.EventHandler;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;

import static ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType.ALARM_TURNED_ON;

public class AlarmEventHandler implements EventHandler {
    Alarm alarm;

    public AlarmEventHandler(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void handleEvent(Object o) {
        SensorEvent event = (SensorEvent) o;
        if (alarm.isActivated()) {
            switch (event.getType()) {
                case ALARM_TURNED_OFF:
                    alarm.deActivate();
                    return;

                case ALARM_TURNED_ON:
                    System.out.println("Already activated");
                    return;
            }
            alarm.switchToShoutingMode();
        } else if(event.getType() == ALARM_TURNED_ON){

        }
    }
}
