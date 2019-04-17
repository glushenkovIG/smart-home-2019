package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.SmartHome.SmartHome;

public class Alarm {
    /*
    0 - deactivated
    1 - activated
    2 - shouting
     */
    private AlarmStateType stateId = AlarmStateType.DEACTIVE_MODE;
    private AlarmState alarmState = new DeactivatedAlarmState(this);

    public Alarm(SmartHome smartHome){
        /* todo why empty constructor*/
    }

    public void activate(){
        alarmState.activate();
    }
    public void deActivate(){
        alarmState.deActivate();
    }
    public void switchToShoutingMode(){
        alarmState.switchToShoutingMode();
    }

    void setState(AlarmState alarmState){
        this.alarmState = alarmState;
    }

    public void setActivatedFlag(AlarmStateType a){ stateId = a;}

    public AlarmStateType getStateType() {
        return stateId;
    }
}
