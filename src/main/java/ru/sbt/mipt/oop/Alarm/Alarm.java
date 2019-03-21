package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.SmartHome.SmartHome;

public class Alarm {
    boolean isActivated = false;
    AlarmState alarmState = new DeactivatedAlarmState(this);

    public Alarm(SmartHome smartHome){
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

    public boolean isActivated() {
        return isActivated;
    }
    public void setState(AlarmState alarmState){
        this.alarmState = alarmState;
    }
    public void setActivatedFlag(boolean a){}
}
