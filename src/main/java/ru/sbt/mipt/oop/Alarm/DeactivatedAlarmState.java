package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.Alarm.AlarmState;

public class DeactivatedAlarmState extends AlarmState {

    public DeactivatedAlarmState(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activate() {
        alarm.setState(new ActivatedAlarmState(alarm));
        alarm.setActivatedFlag(true);

    }

    @Override
    public void deActivate() {

    }

    @Override
    public void switchToShoutingMode() {

    }
}
