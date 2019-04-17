package ru.sbt.mipt.oop.Commands;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.SmartHome.SmartHome;

public class ActivateAlarmCommand extends Command {
    public ActivateAlarmCommand(SmartHome smartHome, Alarm alarm) {
        super(smartHome, alarm);
    }

    @Override
    public void execute() {
        alarm.activate("password1234");
    }
}
