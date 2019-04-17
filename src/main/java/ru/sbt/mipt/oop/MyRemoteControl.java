package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Commands.*;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.rc.RemoteControl;

import java.util.HashMap;
import java.util.Map;

import static ru.sbt.mipt.oop.RemoteControlCommandType.*;
import static ru.sbt.mipt.oop.RemoteControlCommandType.CLOSE_ENTRANCE_DOOR;

public class MyRemoteControl implements RemoteControl {
    final private SmartHome smartHome;
    final private Alarm alarm;
    /* todo split it into separate function */
    private Map<RemoteControlCommandType, Command> commandsMap;
    private Map<String, RemoteControlCommandType> userSettings;

    MyRemoteControl(SmartHome smartHome, Alarm alarm, Map<String, RemoteControlCommandType> settings){
        this.smartHome = smartHome;
        this.alarm = alarm;
        this.userSettings = settings;
        commandsMap = getDefaultCommandsMap();
    }

    private Map<RemoteControlCommandType, Command> getDefaultCommandsMap() {
        Map<RemoteControlCommandType, Command> s = new HashMap<>();
        s.put(TURN_OFF_ALL_LIGHT, new TurnAllLightOffCommand(smartHome, alarm));
        s.put(CLOSE_ENTRANCE_DOOR, new CloseEntranceDoorCommand(smartHome, alarm));
        s.put(TURN_ON_CORRIDOR_LIGHT, new TurnAllLightOnCommand(smartHome, alarm));
        s.put(ACTIVATE_ALARM, new ActivateAlarmCommand(smartHome, alarm));
        s.put(TURN_ALARM_TO_SHOUTING_MODE, new TurnAlarmToShoutingModeCommand(smartHome, alarm));
        s.put(TURN_ON_ALL_LIGHT, new TurnAllLightOffCommand(smartHome, alarm));
        return s;
    }

    @Override
    public void onButtonPressed(String buttonCode, String rcId) {
        commandsMap.get(userSettings.get(buttonCode)).execute();
    }
}
