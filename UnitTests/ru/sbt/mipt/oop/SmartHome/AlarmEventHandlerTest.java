package ru.sbt.mipt.oop.SmartHome;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Alarm.Alarm;
import ru.sbt.mipt.oop.Alarm.AlarmStateType;
import ru.sbt.mipt.oop.Event.SensorEvent.AlarmEventHandler;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEvent;
import ru.sbt.mipt.oop.Event.SensorEvent.SensorEventType;
import ru.sbt.mipt.oop.NextEventGetters.NextEventGetter;
import ru.sbt.mipt.oop.NextEventGetters.RandomSensorNextEventGetter;

public class AlarmEventHandlerTest {
    private SmartHomeReader reader = new SmartHomeGsonReader("smart-home-1.js");
    private SmartHome smartHome = reader.Read();
    private Alarm alarm = new Alarm(smartHome, "MyStrongPass");
    private AlarmEventHandler handler = new AlarmEventHandler(alarm);

    @Test
    public void unit1() {
        handler.handleEvent(new SensorEvent(SensorEventType.ALARM_TURNED_ON));
        Assert.assertEquals(alarm.getStateType(), AlarmStateType.ACTIVE_MODE);

        handler.handleEvent(new SensorEvent(SensorEventType.ALARM_TURNED_OFF));
        Assert.assertEquals(alarm.getStateType(), AlarmStateType.DEACTIVE_MODE);

        handler.handleEvent(new SensorEvent(SensorEventType.ALARM_TURNED_ON));
        handler.handleEvent(new SensorEvent(SensorEventType.DOOR_OPEN, null));

        //switched into shouting mode
        Assert.assertEquals(alarm.getStateType(), AlarmStateType.SHOUTING_MODE);

    }
}