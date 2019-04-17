package ru.sbt.mipt.oop.Commands;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

public abstract class Command {
    final SmartHome smartHome;
    final Alarm alarm;

    Command(SmartHome smartHome, Alarm alarm){
        this.smartHome = smartHome;
        this.alarm = alarm;
    }

    public abstract void execute();
}
