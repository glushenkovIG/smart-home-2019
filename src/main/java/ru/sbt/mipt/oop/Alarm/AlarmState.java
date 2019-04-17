package ru.sbt.mipt.oop.Alarm;

public abstract class AlarmState {
    Alarm alarm;
    public AlarmState(Alarm alarm){
        this.alarm = alarm;
    }

    abstract void activate();

    abstract void deActivate();

    abstract void switchToShoutingMode();
}

