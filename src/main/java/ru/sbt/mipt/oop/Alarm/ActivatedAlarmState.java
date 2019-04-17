package ru.sbt.mipt.oop.Alarm;

public class ActivatedAlarmState extends AlarmState {
    ActivatedAlarmState(Alarm alarm) {
        super(alarm);
    }

    @Override
    void activate() {

    }

    @Override
    public void deActivate() {
        alarm.setState(new DeactivatedAlarmState(alarm));
        alarm.setActivatedFlag(AlarmStateType.DEACTIVE_MODE);
    }

    @Override
    public void switchToShoutingMode() {
        alarm.setState(new ShoutingAlarmState(alarm));
        alarm.setActivatedFlag(AlarmStateType.SHOUTING_MODE);
    }
}
