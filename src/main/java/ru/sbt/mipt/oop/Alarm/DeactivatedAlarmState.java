package ru.sbt.mipt.oop.Alarm;


public class DeactivatedAlarmState extends AlarmState {

    DeactivatedAlarmState(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void activate() {
        alarm.setState(new ActivatedAlarmState(alarm));
        alarm.setActivatedFlag(AlarmStateType.ACTIVE_MODE);
    }

    @Override
    public void deActivate() {

    }

    @Override
    public void switchToShoutingMode() {

    }
}
