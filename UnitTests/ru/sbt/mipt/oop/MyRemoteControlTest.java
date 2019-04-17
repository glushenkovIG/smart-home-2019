package ru.sbt.mipt.oop;

import org.junit.Assert;
import ru.sbt.mipt.oop.rc.RemoteControlRegistry;
import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Alarm.AlarmStateType;
import ru.sbt.mipt.oop.SmartHome.SmartHome;
import ru.sbt.mipt.oop.SmartHome.SmartHomeGsonReader;
import ru.sbt.mipt.oop.SmartHome.SmartHomeReader;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static ru.sbt.mipt.oop.RemoteControlCommandType.*;

public class MyRemoteControlTest {

    @Test
    public void unit1(){
        SmartHomeReader reader = new SmartHomeGsonReader("smart-home-1.js");
        SmartHome smartHome = reader.Read();

        Alarm alarm = new Alarm(smartHome, "password1234");
        Map<String, RemoteControlCommandType> s = new HashMap<>();

        s.put("1", TURN_OFF_ALL_LIGHT);
        s.put("2", CLOSE_ENTRANCE_DOOR);
        s.put("3", TURN_ON_CORRIDOR_LIGHT);
        s.put("4", ACTIVATE_ALARM);
        s.put("A", TURN_ALARM_TO_SHOUTING_MODE);
        s.put("B", TURN_ON_ALL_LIGHT);
        s.put("C", TURN_OFF_ALL_LIGHT);
        s.put("D", CLOSE_ENTRANCE_DOOR);

        MyRemoteControl myRemoteControl = new MyRemoteControl(smartHome, alarm, s);

        RemoteControlRegistry remoteControlRegistry = new RemoteControlRegistry();
        remoteControlRegistry.registerRemoteControl(myRemoteControl, "123456");

        myRemoteControl.onButtonPressed("4", "123456");
        Assert.assertEquals(alarm.getStateType(), AlarmStateType.ACTIVE_MODE);
        myRemoteControl.onButtonPressed("A", "123456");
        Assert.assertEquals(alarm.getStateType(), AlarmStateType.SHOUTING_MODE);
    }

}