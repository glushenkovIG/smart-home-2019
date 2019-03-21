package ru.sbt.mipt.oop.Alarm;

public class ActivatedAlarmState extends AlarmState {
    public ActivatedAlarmState(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activate() {

    }

    @Override
    public void deActivate() {
        alarm.setState(new DeactivatedAlarmState(alarm));
        alarm.setActivatedFlag(false);
    }

    @Override
    public void switchToShoutingMode() {
        alarm.setState(new ShoutingAlarmState(alarm));
        alarm.setActivatedFlag(false);
    }
}
