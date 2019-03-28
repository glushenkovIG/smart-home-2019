package ru.sbt.mipt.oop.Alarm;

public class ShoutingAlarmState extends AlarmState {
    public ShoutingAlarmState(Alarm alarm) {
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

    }
}
