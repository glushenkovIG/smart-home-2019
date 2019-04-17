package ru.sbt.mipt.oop.Alarm;

import ru.sbt.mipt.oop.SmartHome.SmartHome;

public class Alarm {
    /*
    0 - deactivated
    1 - activated
    2 - shouting
     */
    private final String password;
    private AlarmStateType stateId = AlarmStateType.DEACTIVE_MODE;
    private AlarmState alarmState = new DeactivatedAlarmState(this);

    public Alarm(SmartHome smartHome, String password){
        this.password = password;
        /* todo why empty constructor*/
    }

    public void activate(String password){
        if(checkPassword(password)) {
            alarmState.activate();
        }
    }

    public void deActivate(String password){
        if(checkPassword(password)) {
            alarmState.deActivate();
        }
    }

    public void switchToShoutingMode(){
        alarmState.switchToShoutingMode();
    }

    void setState(AlarmState alarmState){
        this.alarmState = alarmState;
    }

    void setActivatedFlag(AlarmStateType a){ stateId = a;}

    public AlarmStateType getStateType() {
        return stateId;
    }

    private boolean checkPassword(String password){
        return password.equals(this.password);
    }

    public String getPassword() {
        return password;
    }
}
